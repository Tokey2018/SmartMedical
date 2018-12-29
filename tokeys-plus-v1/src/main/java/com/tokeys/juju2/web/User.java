package com.tokeys.juju2.web;

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
public class User {
    @GetMapping("/reg88/{id}")
    public  String reg (@PathVariable long id){
        return "11111";
    }
     @GetMapping("/login")
    public  String login (long id){
        return "@@@@登录成功,拦截!!";
    }
   @GetMapping("/send2")
    public  Object send (String  code){
       Map<String, Object> map= new ConcurrentHashMap<>();
       map.put("手机号",000000);
       map.put("验证码",8888);
        return  map;
    }

}
