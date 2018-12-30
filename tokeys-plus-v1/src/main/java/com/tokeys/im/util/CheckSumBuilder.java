package com.tokeys.im.util;

import com.tokeys.im.enums.YunXinAPPKey;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.MessageDigest;
import java.util.Date;

/**
 * 网易云信 API checksum校验,http请求头需要此采参数
 */
public enum CheckSumBuilder {
    BUILDER;

    CheckSumBuilder() {
    }

    /**
     *当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
     */
    public String curTime;
    /**
     *随机数（最大长度128个字符）
     */
    public  String nonce;

    public String getCurTime() {
        return curTime;
    }

    public String getNonce() {
        return nonce;
    }

    /**
     * 计算并获取 CheckSum:
     * SHA1(AppSecret + Nonce + CurTime)，三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
     */
    public String getCheckSum() {
        this.curTime = String.valueOf((new Date()).getTime() / 1000L);
        this.nonce = RandomStringUtils.random(8, false, true);
        return encode("sha1", YunXinAPPKey.YUNXIN_APPSECRET.getValue() + nonce + curTime);
    }

    // 计算并获取CheckSum
    public String getCheckSum(String appSecret, String nonce, String curTime) {
        this.curTime = String.valueOf((new Date()).getTime() / 1000L);
        this.nonce = RandomStringUtils.random(8, false, true);
        return encode("sha1", appSecret + nonce + curTime);
    }

    // 计算并获取md5值
    public String getMD5(String requestBody) {
        return encode("md5", requestBody);
    }

    private String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest
                    = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    private final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
}

