package com.tokeys.im.utilWangYi;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Firrela
 * @time 2016/3/7.
 */
public class NIMPost2 {

    private static Logger logger = LoggerFactory.getLogger(NIMPost2.class);

    public static String postNIMServer(String url, final HttpEntity entity, String appKey, String appSecret)
            throws IOException {
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        HttpPost post = httpClientUtil.createPost(url, entity, null);

        // addHeader
        HttpClientUtil.addHeader(post, "AppKey", appKey);
        String nonce = UUIDUtil.getUUID();
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        HttpClientUtil.addHeader(post, "Nonce", nonce);
        HttpClientUtil.addHeader(post, "CurTime", curTime);
        String checksum = getCheckSum(nonce, curTime, appSecret);
        HttpClientUtil.addHeader(post, "CheckSum", checksum);

        // logger
        logger.info("Nonce {} | CurlTime {} | CheckSum {}", new Object[]{nonce, curTime, checksum});

        return httpClientUtil.fetchData(post);
    }

    private static String getCheckSum(String nonce, String curTime, String appSecret) {
        String plaintext = new StringBuffer(appSecret).append(nonce).append(curTime).toString();
        return EncodeUtil.encode(plaintext, "SHA1");
    }
}
