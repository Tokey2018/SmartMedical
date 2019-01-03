package com.tokeys.im.web.api;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tokeys.im.enums.YunXinIMServcice;
import com.tokeys.im.util.CacheUtil;
import com.tokeys.im.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送验证短信
 * Created by Administrator on 2019/01/01.
 * 若是有了共享数据，那为了线程安全，我们可以设置singleton=“false”来保证其安全性。
 * https://blog.csdn.net/liangzi4454/article/details/9213657
 */
@Component("singleton=“false”")
//@Component(value = "singleton=“false”")
public class SendSMS {

    @Autowired
    CacheUtil cacheUtil;

    public boolean sendSmsCode(String phone) {
        Map<String, Object> map = new HashMap();
        map.put("mobile", phone);
        String result = HttpClientUtil.INSTANCE.postForm(map, YunXinIMServcice.SEND_SMS.getApi());
        //返回结果:{"msg":"13683","code":200,"obj":"2864"}
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if (null != jsonObject && null != jsonObject.get("obj")) {
            String code = jsonObject.get("obj").toString();

            //当前放入EhCache缓存即可,不用放到redis 或者数据库.
            if (null == cacheUtil.getCache("code")) {
                cacheUtil.put("code", phone, code);
            } else {
                cacheUtil.getCache("code").clear();
                cacheUtil.put("code", phone, code);
            }
            return true;
        }
        return false;
    }

    public  boolean checkSmsCode(String phone,String code ) {
        try {
            String smscode = cacheUtil.getCache("code").get(phone).get().toString();
            if (null != smscode && smscode.equals(code)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
