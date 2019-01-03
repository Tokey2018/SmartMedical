package com.tokeys.juju;

import com.tokeys.im.util.CacheUtil;
import com.tokeys.im.web.api.SendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/11/08.
 */
@RestController
@RequestMapping("/api")
public class UserTest {
   @Autowired
   CacheUtil cacheUtil;
    @Autowired
    SendSMS sendSMS;

    @GetMapping("/reg88/{id}")
    public String reg(@PathVariable long id) {
        return "11111";
    }

    @GetMapping("/login")
    public String login(long id) {
        return "@@@@登录成功,拦截!!";
    }

    @GetMapping("/send2")
    public Object send(String code) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("手机号", 000000);
        map.put("验证码", 8888);
        return map;
    }

    /**
     * EhCacheCacheManager 缓存测试
     *
     * @return
     */
    @GetMapping("/getCache")
    public String put() {
        cacheUtil.getCache("code").put("133***********93", "缓存对象是:123456");

        Cache cache = cacheUtil.getCache("code");
        System.out.println("没有删除前的缓存==" + cache.get("133***********93").get().toString());
        //  cache.clear();
        return cache.get("133***********93").get().toString();
        // return "";
    }

    @GetMapping("/sendSmsCode")
    public boolean sendSmsCode(String phone) {

        return sendSMS.sendSmsCode(phone);
    }


    @GetMapping("/checkSmsCode")
    public boolean checkSmsCode(String phone,String code) {

        return sendSMS.checkSmsCode(phone,code);
    }
}
