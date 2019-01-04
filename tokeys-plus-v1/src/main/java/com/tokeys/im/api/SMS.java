package com.tokeys.im.api;

import com.tokeys.im.servcice.SendSMSService;
import com.tokeys.im.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送验证短信API
 *
 * @version 1.0
 */

@RestController
@RequestMapping("/api/sms")
public class SMS {

    @Autowired
    CacheUtil cacheUtil;
    @Autowired
    SendSMSService sendSMSService;

    @GetMapping("/sendSmsCode")
    public boolean sendSmsCode(String phone) {

        return sendSMSService.sendSmsCode(phone);
    }

    @GetMapping("/checkSmsCode")
    public boolean checkSmsCode(String phone, String code) {

        return sendSMSService.checkSmsCode(phone, code);
    }
}
