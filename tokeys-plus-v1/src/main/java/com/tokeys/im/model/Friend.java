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

    /* alias	String	否	给好友增加备注名，限制长度128*/
    public String alias;

    /*  ex	String	否	修改ex字段，限制长度256*/
    public String ex;

    /* serverex	String	否	修改serverex字段，限制长度256
     此字段client端只读，server端读写*/
    public String serverex;

    /* 以下参数用途: 拉黑/取消拉黑；设置静音/取消静音 */

    /*  targetAcc	String	是	被加黑或加静音的帐号*/
    public String targetAcc;

    /* relationType	int	是	本次操作的关系类型,1:黑名单操作，2:静音列表操作*/
    public int relationType;

    /* value	int	是	操作值，0:取消黑名单或静音，1:加入黑名单或静音*/
    public int value;

    /*  updatetime	Long	是	更新时间戳，接口返回该时间戳之后有更新的好友列表*/
    public Long updatetime;

    /*createtime	Long	否	【Deprecated】定义同updatetime*/
    public Long createtime;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getServerex() {
        return serverex;
    }

    public void setServerex(String serverex) {
        this.serverex = serverex;
    }

    public String getTargetAcc() {
        return targetAcc;
    }

    public void setTargetAcc(String targetAcc) {
        this.targetAcc = targetAcc;
    }

    public int getRelationType() {
        return relationType;
    }

    public void setRelationType(int relationType) {
        this.relationType = relationType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}
