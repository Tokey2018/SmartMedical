package com.tokeys.token;

public enum JWTConstant {
    JWT_ID("20181228a"),
    JWT_SECERT("7786df7fc3a34e26a61c034d5ec8245d"),
    //token有效时间1小时: 3600_000    6分钟 :  1 * 60 * 1000
    EXPIRATION_TIME(3600_000),
    //刷新TOKEN(有返回数据)
    RESCODE_REFTOKEN_MSG(1006),
    //刷新TOKEN
    RESCODE_REFTOKEN(1007),

     JWT_ERRCODE_CODE("code"),
    //Token过期
    JWT_ERRCODE_EXPIRE(4001),
    //验证不通过
    JWT_ERRCODE_FAIL(4002),
    //jwt 数据不对
    JWT_ERRCODE_DATA(4003),
    ;
    public String vlaue;
    public long lg;

    public String getVlaue() {
        return vlaue;
    }

    public long getLg() {
        return lg;
    }

    JWTConstant(String vlaue) {
        this.vlaue=vlaue;
    }

    JWTConstant(long lg) {
        this.lg=lg;
    }

}
