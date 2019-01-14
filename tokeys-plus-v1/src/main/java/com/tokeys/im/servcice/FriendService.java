package com.tokeys.im.servcice;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ibeetl.admin.core.web.JsonResult;
import com.tokeys.im.enums.YunXinIMApi;
import com.tokeys.im.model.Friend;
import com.tokeys.im.util.HttpClientUtil;
import com.tokeys.im.util.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Service
public class FriendService {
    /**
     * 添加好友
     * accid	String	必须	   加好友发起者accid
     * faccid	String	必须	   加好友接收者accid
     * type  	int	    必须  	1直接加好友，2请求加好友，3同意加好友，4拒绝加好友
     * msg	 String	  否	加好友对应的请求消息，第三方组装，最长256字符
     *
     * @param friend
     * @return
     */
    public JsonResult<JSONObject> add(Friend friend) {
        Map friendMap = null;
        try {
            friendMap = ResultUtil.INSTANCE.objectToMap( friend );
            String strjson = HttpClientUtil.INSTANCE.postForm( friendMap, YunXinIMApi.FRIEND_ADD.getApi() );
            return ResultUtil.INSTANCE.getResult( strjson );
        } catch (IllegalAccessException e) {
            return JsonResult.failMessage( e.getMessage() );
        }
    }

    public JsonResult<JSONObject> update(Friend friend) {
        try {
            Map friendMap = ResultUtil.INSTANCE.objectToMap( friend );
            String strjson = HttpClientUtil.INSTANCE.postForm( friendMap, YunXinIMApi.FRIEND_UPDATE.getApi() );
            return ResultUtil.INSTANCE.getResult( strjson );
        } catch (IllegalAccessException e) {
            return JsonResult.failMessage( e.getMessage() );

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
        friendMap.put( "accid", accid );
        friendMap.put( "updatetime", updatetime );
        friendMap.put( "createtime", createtime );
        String strjson = HttpClientUtil.INSTANCE.postForm( friendMap, YunXinIMApi.FRIEND_GET.getApi() );
        return ResultUtil.INSTANCE.getResult( strjson );

    }

    /**
     * 拉黑/取消拉黑；设置静音/取消静音
     *
     * @param friend
     * @return
     */
    public JsonResult<JSONObject> setSpecialRelation(Friend friend) {
        try {
            Map friendMap = ResultUtil.INSTANCE.objectToMap( friend );
            String strjson = HttpClientUtil.INSTANCE.postForm( friendMap, YunXinIMApi.FRIEND_SETSPECIALRELATION.getApi() );
            return ResultUtil.INSTANCE.getResult( strjson );
        } catch (IllegalAccessException e) {
            return JsonResult.failMessage( e.getMessage() );

        }
    }

    // 批量添加好友普通方法,
    public void batchAdd(List<Friend> friends) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < friends.size(); i++) {
            Friend friend = friends.get( i );
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    add( friend );
                }
            };
            executor.execute( runnable );
        }
        executor.shutdown();
    }

    /**
     * 采用 :FIXME 线程池    ,http请求也应该使用连接池
     * 增加返回结果,只要一个添加失败成功,就全部添加失败,必须全部成功,才成功.
     * executor.execute( new Thread( futureTask ) ) 等价  executor.execute( futureTask ) ;
     *
     * @return
     */
    public JsonResult<JSONObject> batchStrongAdd(List<Friend> friends) {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<JsonResult> futureTask = null;
        for (int i = 0; i < friends.size(); i++) {
            Friend friend = friends.get( i );
            ResultCode resutlThread = new ResultCode( friend );
            futureTask = new FutureTask<JsonResult>( resutlThread );
            executor.execute( futureTask );
            try {
                JSONObject obj = JSONUtil.parseObj( futureTask.get() );
                if ("500".equals( obj.get( "code" ).toString() )) {
                    executor.shutdown();
                    return JsonResult.failMessage( obj.toString() );
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                return JsonResult.failMessage( e.getMessage() );
            } catch (ExecutionException e) {
                executor.shutdownNow();
                return JsonResult.failMessage( e.getMessage() );
            }
        }
        executor.shutdown();
        return JsonResult.success();
    }


    /**
     * 增加返回结果: 没有添加成功的用户记录到日志表里面!!!
     *
     * @return
     */
    public JsonResult<JSONObject> batchStrongLogAdd(List<Friend> friends) {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<JsonResult> futureTask = null;
        int j = 0;
        for (int i = 0; i < friends.size(); i++) {
            Friend friend = friends.get( i );
            ResultCode resutlThread = new ResultCode( friend );
            futureTask = new FutureTask<JsonResult>( resutlThread );
            executor.execute( futureTask );
            try {
                JSONObject obj = JSONUtil.parseObj( futureTask.get() );
                if ("500".equals( obj.get( "code" ).toString() )) {
                    j++;
                    //TODO
                    System.out.print( "记录到日志表log  错误数量111j=" + j );
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                return JsonResult.failMessage( e.getMessage() );
            } catch (ExecutionException e) {
                executor.shutdownNow();
                return JsonResult.failMessage( e.getMessage() );
            }
        }
        executor.shutdown();
        return JsonResult.success();
    }

    /**
     * 采用 :FIXME  Fork Join 将数量分批执行 ，等全部完成后才 返回执行结果
     *
     * @return
     */
    public JsonResult<JSONObject> batchForkJoinAdd() {


        return null;
    }




    // TODO 删除好友
    // TODO 查看指定用户的黑名单和静音列表
}






