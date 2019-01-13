package com.tokeys.im.servcice;

import cn.hutool.json.JSONObject;
import com.ibeetl.admin.core.web.JsonResult;
import com.tokeys.im.enums.YunXinIMApi;
import com.tokeys.im.model.Friend;
import com.tokeys.im.util.HttpClientUtil;
import com.tokeys.im.util.ResultUtil;

import java.util.HashMap;
import java.util.Map;

public class FriendService {
    /**
     * 添加好友
     *
     * @param friend
     * @return
     */
    public JsonResult<JSONObject> add(Friend friend) {
        Map friendMap = null;
        try {
            friendMap = ResultUtil.INSTANCE.objectToMap(friend);
            String strjson = HttpClientUtil.INSTANCE.postForm(friendMap, YunXinIMApi.FRIEND_ADD.getApi());
            return ResultUtil.INSTANCE.getResult(strjson);
        } catch (IllegalAccessException e) {
            return JsonResult.failMessage(e.getMessage());
        }
    }

    public JsonResult<JSONObject> update(Friend friend) {
        try {
            Map friendMap = ResultUtil.INSTANCE.objectToMap(friend);
            String strjson = HttpClientUtil.INSTANCE.postForm(friendMap, YunXinIMApi.FRIEND_UPDATE.getApi());
            return ResultUtil.INSTANCE.getResult(strjson);
        } catch (IllegalAccessException e) {
            return JsonResult.failMessage(e.getMessage());

        }
    }

    /**
     * 获取好友列表 FIXME  建议从自己的数据库里获取好友列表,不要直接从网易云信上获取
     *
     * @param accid       :必填 发起者accid
     * @param updatetime  :必填 更新时间戳，接口返回该时间戳之后有更新的好友列表
     * @param createtime: 【Deprecated】定义同updatetime
     * @return
     */
    public JsonResult<JSONObject> getFriends(String accid, Long updatetime, Long createtime) {
        Map friendMap = new HashMap();
        friendMap.put("accid", accid);
        friendMap.put("updatetime", updatetime);
        friendMap.put("createtime", createtime);
        String strjson = HttpClientUtil.INSTANCE.postForm(friendMap, YunXinIMApi.FRIEND_GET.getApi());
        return ResultUtil.INSTANCE.getResult(strjson);

    }

    /**
     * 拉黑/取消拉黑；设置静音/取消静音
     *
     * @param friend
     * @return
     */
    public JsonResult<JSONObject> setSpecialRelation(Friend friend) {
        try {
            Map friendMap = ResultUtil.INSTANCE.objectToMap(friend);
            String strjson = HttpClientUtil.INSTANCE.postForm(friendMap, YunXinIMApi.FRIEND_SETSPECIALRELATION.getApi());
            return ResultUtil.INSTANCE.getResult(strjson);
        } catch (IllegalAccessException e) {
            return JsonResult.failMessage(e.getMessage());

        }
    }
    // TODO 批量添加好友


    // TODO 删除好友
    // TODO 查看指定用户的黑名单和静音列表
}
