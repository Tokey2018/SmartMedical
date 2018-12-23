package com.tokeys.im.enums;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

/**
 * 网易云信 API
 * Created by Administrator on 2018/11/27.
 */
public enum YunXinIMServcice {

    /*用户*/
    USER_CREATE("POST创建网易云信唯一id","https://api.netease.im/nimserver/user/create.action"),
    USER_UPDATEUINFO("POST更新网易云信用户信息","https://api.netease.im/nimserver/user/updateUinfo.action"),
    USER_GETUINFOS("POST获取用户名片","https://api.netease.im/nimserver/user/getUinfos.action"),
    USER_SETDONNOP("POST设置桌面端在线时，移动端是否需要推送","https://api.netease.im/nimserver/user/setDonnop.action "),
    USER_MUTE("POST账号全局禁言","https://api.netease.im/nimserver/user/mute.action"),
    USER_MUTEAV("POST账号全局禁用音视频","https://api.netease.im/nimserver/user/muteAv.action"),

    /*好友*/
    FRIEND_ADD ("POST加好友","https://api.netease.im/nimserver/friend/add.action"),
    FRIEND_UPDATE("POST更新好友相关信息 ","https://api.netease.im/nimserver/friend/update.action"),
    FRIEND_DELETE("POST删除好友 ","https://api.netease.im/nimserver/friend/delete.action"),
    FRIEND_GET("POST 获取好友关系","https://api.netease.im/nimserver/friend/get.action"),
    FRIEND_SETSPECIALRELATION("POST 设置黑名单/静音","https://api.netease.im/nimserver/user/setSpecialRelation.action"),
    FRIEND_LISTBLACKANDMUTELIST("POST查看指定用户的黑名单和静音列表 ","https://api.netease.im/nimserver/user/listBlackAndMuteList.action"),

    /*群*/
    TEAMC_REATE("POST创建群","https://api.netease.im/nimserver/team/create.action"),
    TEAMC_ADD("POST拉人入群","https://api.netease.im/nimserver/team/add.action"),
    TEAMC_KICK("POST踢人出群","https://api.netease.im/nimserver/team/kick.action"),
    TEAMC_REMOVE("POST解散群","https://api.netease.im/nimserver/team/remove.action"),
    TEAMC_UPDATE("POST编辑群资料","https://api.netease.im/nimserver/team/update.action"),
    TEAMC_QUERY("POST群信息与成员列表查询","https://api.netease.im/nimserver/team/query.action"),
    TEAMC_QUERYDETAIL("POST获取群组详细信息","https://api.netease.im/nimserver/team/queryDetail.action"),
    TEAMC_GETMARKREADINFO("POST获取群组已读消息的已读详情信息","https://api.netease.im/nimserver/team/getMarkReadInfo.action"),
    TEAMC_CHANGEOWNER("POST移交群主","https://api.netease.im/nimserver/team/changeOwner.action"),
    TEAMC_ADDMANAGER("POST任命管理员","https://api.netease.im/nimserver/team/addManager.action"),
    TEAMC_REMOVEMANAGER("POST移除管理员","https://api.netease.im/nimserver/team/removeManager.action"),
    TEAMC_JOINTEAMS("POST获取某用户所加入的群信息","https://api.netease.im/nimserver/team/joinTeams.action"),
    TEAMC_UPDATETEAMNICK("POST修改群昵称","https://api.netease.im/nimserver/team/updateTeamNick.action"),
    TEAMC_MUTETEAM("POST修改消息提醒开关","https://api.netease.im/nimserver/team/muteTeam.action"),
    TEAMC_MUTETLIST("POST禁言群成员","https://api.netease.im/nimserver/team/muteTlist.action"),
    TEAMC_LEAVE("POST主动退群","https://api.netease.im/nimserver/team/leave.action"),
    TEAMC_MUTETLISTALL("POST将群组整体禁言 _静音","https://api.netease.im/nimserver/team/muteTlistAll.action"),
    TEAMC_LISTTEAMMUTE("POST获取群组禁言列表","https://api.netease.im/nimserver/team/listTeamMute.action"),
    ;


    private String description;
    private String api;

    YunXinIMServcice(String description, String api) {
        this.description = description;
        this.api = api;
    }

    public String getDescription() {
        return description;
    }

    public String getApi() {
        return api;
    }

}
