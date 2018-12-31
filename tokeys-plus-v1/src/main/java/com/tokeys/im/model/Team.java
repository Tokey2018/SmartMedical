package com.tokeys.im.model;

/**
 * 网易云信 群模型
 */
public class Team {

    /* tname	String	是	群名称，最大长度64字符*/
    public String tname;

    /*  owner	String	是	群主用户帐号，最大长度32字符*/
    public String owner;

    /*  members	String	 群成员 是	["aaa","bbb"](JSONArray对应的accid，如果解析出错会报414)，一次最多拉200个成员*/
    public String members;

    /*announcement	String	否	群公告，最大长度1024字符*/
    public String announcement;

    /*intro	String	否	群描述，最大长度512字符*/
    public String intro;

    /* msg	String	是	 邀请发送的文字，最大长度150字符*/
    public String msg;

    /* magree	int	是	管理后台建群时，0不需要被邀请人同意加入群，1需要被邀请人同意才可以加入群。其它会返回414*/
    public int magree;

    /* joinmode	int	是	群建好后，sdk操作时，0不用验证，1需要验证,2不允许任何人加入。其它返回414*/
    public int joinmode;

    /*custom	String	否	自定义高级群扩展属性，第三方可以跟据此属性自定义扩展自己的群属性。（建议为json）,最大长度1024字符*/
    public String custom;

    /* icon	String	否	群头像，最大长度1024字符*/
    public String icon;

    /* beinvitemode	int	否	被邀请人同意方式，0-需要同意(默认),1-不需要同意。其它返回414*/
    public int beinvitemode;

    /* invitemode	int	否	谁可以邀请他人入群，0-管理员(默认),1-所有人。其它返回414*/
    public int invitemode;

    /* uptinfomode	int	否	谁可以修改群资料，0-管理员(默认),1-所有人。其它返回414*/
    public int uptinfomode;

    /*upcustommode	int	否	谁可以更新群自定义属性，0-管理员(默认),1-所有人。其它返回414*/
    public int upcustommode;

    /* teamMemberLimit	int	否	该群最大人数(包含群主)，范围： 2至应用定义的最大群人数(默认:200)。其它返回414*/
    public int teamMemberLimit;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getMagree() {
        return magree;
    }

    public void setMagree(int magree) {
        this.magree = magree;
    }

    public int getJoinmode() {
        return joinmode;
    }

    public void setJoinmode(int joinmode) {
        this.joinmode = joinmode;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getBeinvitemode() {
        return beinvitemode;
    }

    public void setBeinvitemode(int beinvitemode) {
        this.beinvitemode = beinvitemode;
    }

    public int getInvitemode() {
        return invitemode;
    }

    public void setInvitemode(int invitemode) {
        this.invitemode = invitemode;
    }

    public int getUptinfomode() {
        return uptinfomode;
    }

    public void setUptinfomode(int uptinfomode) {
        this.uptinfomode = uptinfomode;
    }

    public int getUpcustommode() {
        return upcustommode;
    }

    public void setUpcustommode(int upcustommode) {
        this.upcustommode = upcustommode;
    }

    public int getTeamMemberLimit() {
        return teamMemberLimit;
    }

    public void setTeamMemberLimit(int teamMemberLimit) {
        this.teamMemberLimit = teamMemberLimit;
    }
}
