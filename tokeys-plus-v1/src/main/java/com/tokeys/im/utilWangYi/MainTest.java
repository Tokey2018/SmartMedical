package com.tokeys.im.utilWangYi;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Firrela
 * @time 2016/3/7.
 */
public class MainTest {

    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    private static String APPKEY = "";  //AppKey
    private static String SECRET = "";  //AppSecret

    public static final void main(String[] args) throws IOException {
        // 我在网易云信的accid
        String res = createUser("20161115289336n3");

        System.out.println(res);
        //TODO: 对结果的业务处理，如解析返回结果，并保存成功注册的用户
    }

    public static String createUser(String accid) throws IOException {
        String url = "https://api.netease.im/nimserver/user/create.action";
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("accid", accid));
       /* params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("token", token));*/

        //UTF-8编码,解决中文问题
        HttpEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
       // FIXME 网易云信注册
        String res = NIMPost.postNIMServer(url, entity, "0e0b509684d0492df6b70b53c9ffca0f", "44d96b39d54b");
        logger.info("createUser httpRes: {}", res);
        return res;
    }
}
