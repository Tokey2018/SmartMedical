package com.tokeys.im.model;

/**
 * 网易云信 用户模型
 */
public class IMUser {
    /* accid	String	是	用户帐号，最大长度32字符，必须保证一个APP内唯一*/
    public String accid;

    /*  name	String	否	用户昵称，最大长度64字符，可设置为空字符串*/
    public String name;

    /*  icon	String	否	用户头像，最大长度1024字节，可设置为空字符串*/
    public String icon;

    /* sign	String	否	用户签名，最大长度256字符，可设置为空字符串*/
    public String sign;

    /*email	String	否	用户email，最大长度64字符，可设置为空字符串*/
    public String email;

    /*    birth	String	否	用户生日，最大长度16字符，可设置为空字符串*/
    public String birth;

    /* mobile	String	否	用户mobile，最大长度32字符，非中国大陆手机号码需要填写国家代码(如美国：+1-xxxxxxxxxx)或地区代码(如香港：+852-xxxxxxxx)，可设置为空字符串*/
    public String mobile;

    /*  gender	int	否	用户性别，0表示未知，1表示男，2女表示女，其它会报参数错误*/
    public int gender;

    /*    ex	String	否	用户名片扩展字段，最大长度1024字符，用户可自行扩展，建议封装成JSON字符串，也可以设置为空字符串*/
    public String ex;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
