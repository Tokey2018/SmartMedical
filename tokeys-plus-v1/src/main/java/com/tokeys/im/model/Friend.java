package com.tokeys.im.model;

/**
 * 好友
 */
public class Friend {
    /*  accid	String	是	加好友发起者accid*/
    public String accid;
    /*faccid	String	是	加好友接收者accid*/
    public String faccid;
    /*type	int	是	1直接加好友，2请求加好友，3同意加好友，4拒绝加好友*/
    public int type;
    /*  msg	String	否	加好友对应的请求消息，第三方组装，最长256字符*/
    public String msg;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getFaccid() {
        return faccid;
    }

    public void setFaccid(String faccid) {
        this.faccid = faccid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
