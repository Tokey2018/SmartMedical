package com.tokeys.im.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import com.ibeetl.admin.core.web.JsonResult;
import com.tokeys.im.enums.YunXinIMApi;
import com.tokeys.im.model.IMUser;
import com.tokeys.im.util.HttpClientUtil;
import com.tokeys.im.util.ResultUtil;

import java.util.HashMap;
import java.util.Map;

public class ImUserApi {


    /**
     * 创建网易云信 用户
     *
     * @param user
     * @return
     */
    public JsonResult<JSONObject> creat(IMUser user) {
        Map mapUser = BeanUtil.beanToMap(user);
        String strjson = HttpClientUtil.INSTANCE.postForm(mapUser, YunXinIMApi.USER_CREATE.getApi());
        return ResultUtil.INSTANCE.getResult(strjson);
    }

    /**
     * 更新网易云信用户
     *
     * @param user
     * @return
     */
    public JsonResult<JSONObject> updateUinfo(IMUser user) {
        if (null != user.getAccid() && !"".equals(user.getAccid())) {
            Map mapUser = BeanUtil.beanToMap(user);
            String strjson = HttpClientUtil.INSTANCE.postForm(mapUser, YunXinIMApi.USER_UPDATEUINFO.getApi());
            return ResultUtil.INSTANCE.getResult(strjson);
        } else {
            return creat(user);
        }
    }

    /**
     * 获取用户名片 一次查询最多为200个
     *
     * @param accids
     * @return
     */
    public JsonResult<JSONObject> getUinfo(String... accids) {
        Map map = new HashMap();
        map.put("accids", ResultUtil.INSTANCE.arrayToString(accids));
        String strjson = HttpClientUtil.INSTANCE.postForm(map, YunXinIMApi.USER_GETUINFOS.getApi());
        return ResultUtil.INSTANCE.getResult(strjson);
    }
    //TODO  设置桌面端在线时，移动端是否需要推送
    //TODO  账号全局禁言
    //TODO  账号全局禁用音视频
}
