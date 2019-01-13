package com.tokeys.im.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ibeetl.admin.core.web.JsonResult;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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

    public String arrayToString(String... str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    /**
     * 对象转Map 忽略空值
     * 来源 https://blog.csdn.net/YeMaZhi/article/details/80820782
     *
     * @param requestParameters
     * @return
     * @throws IllegalAccessException
     */
    public Map<String, String> objectToMap(Object requestParameters) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        // 获取对象对应类中的所有属性域
        Field[] fields = requestParameters.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            // 获取原来的访问控制权限
            boolean accessFlag = fields[i].isAccessible();
            // 修改访问控制权限
            fields[i].setAccessible(true);
            // 获取在对象中属性fields[i]对应的对象中的变量
            Object o = fields[i].get(requestParameters);
            if (o != null && StringUtils.isNotBlank(o.toString().trim())) {
                map.put(varName, o.toString().trim());
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            }
        }
        return map;
    }


}
