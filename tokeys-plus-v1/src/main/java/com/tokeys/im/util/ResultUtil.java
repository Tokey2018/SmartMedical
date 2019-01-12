package com.tokeys.im.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ibeetl.admin.core.web.JsonResult;

public enum ResultUtil {
    INSTANCE;
    public JsonResult<JSONObject> getResult(String strjson) {
        JSONObject obj = JSONUtil.parseObj(strjson);

        if ("200" != obj.get("code")) {
            return JsonResult.failMessage("erro:" + obj.get("desc").toString());
        } else {
            return JsonResult.success(JSONUtil.parseObj(strjson));
        }
    }

    public String  arrayToString(String ... str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

}
