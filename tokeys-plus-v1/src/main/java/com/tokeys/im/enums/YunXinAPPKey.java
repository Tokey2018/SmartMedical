package com.tokeys.im.enums;

/**
 * Created by Administrator on 2018/11/27.
 */
public enum YunXinAPPKey {

    YUNXIN_APPKEY("1111111111111"),

    YUNXIN_APPSECRET("2222222222222");

    private String value;

    YunXinAPPKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
