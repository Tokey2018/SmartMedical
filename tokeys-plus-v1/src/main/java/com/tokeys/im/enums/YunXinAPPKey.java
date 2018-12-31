package com.tokeys.im.enums;

/**
 * Created by Administrator on 2018/11/27.
 */
public enum YunXinAPPKey {
    //0e0b509684d0492df6b70b53c9ffca0f
    YUNXIN_APPKEY("0e0b509684d0492df6b70b53c9ffca0f"),
    //44d96b39d54b
    YUNXIN_APPSECRET("44d96b39d54b");

    private String value;

    YunXinAPPKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
