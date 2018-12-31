package com.tokeys.im.model;

/**
 * 网易云信聊天室模型
 */
public class Chatroom {

    /*    creator	String	是	聊天室属主的账号accid*/
    public String creator;

    /*name	String	是	聊天室名称，长度限制128个字符*/
    public String name;

    /*announcement	String	否	公告，长度限制4096个字符*/
    public String announcement;

    /*broadcasturl	String	否	直播地址，长度限制1024个字符*/
    public String broadcasturl;

    /*ext	String	否	扩展字段，最长4096字符*/
    public String ext;

    /*queuelevel	int	否	队列管理权限：0:所有人都有权限变更队列，1:只有主播管理员才能操作变更。默认0*/
    public int queuelevel;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getBroadcasturl() {
        return broadcasturl;
    }

    public void setBroadcasturl(String broadcasturl) {
        this.broadcasturl = broadcasturl;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getQueuelevel() {
        return queuelevel;
    }

    public void setQueuelevel(int queuelevel) {
        this.queuelevel = queuelevel;
    }
}
