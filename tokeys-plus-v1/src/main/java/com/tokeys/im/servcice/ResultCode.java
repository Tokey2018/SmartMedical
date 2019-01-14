package com.tokeys.im.servcice;

import cn.hutool.json.JSONObject;
import com.ibeetl.admin.core.web.JsonResult;
import com.tokeys.im.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service
public  class ResultCode implements Callable<JsonResult> {

    @Autowired
    public  FriendService friendService;
    public  Friend friend;

    public ResultCode(Friend fd) {
        this.friend = fd;
    }

    @Override
    public JsonResult<JSONObject> call() throws Exception {
        // friendService.add(friend);
        return new FriendService().add( friend );
    }
}