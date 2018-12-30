package com.tokeys.im.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import com.tokeys.im.enums.YunXinAPPKey;

import java.util.Map;

/**
 * Created by Administrator on 2018/12/13.
 * HttpClientUtil 该类要不要做成单例 。必须做成单利
 * http 连接池
 * 线程池执行?
 * 当使用了请求连接池管理器（比如PoolingClientConnectionManager）后，HttpClient就可以同时执行多个线程的请求了。
 * https://www.yeetrack.com/?p=782
 * 即使HttpClient的实例是线程安全的，可以被多个线程共享访问，但是仍旧推荐每个线程都要有自己专用实例的HttpContext。
 */
public enum HttpClientUtil {
    INSTANCE;
    private static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
    private static final String JSON_CONTENT_TYPE = "application/json;charset=utf-8";


// 批量添加好友是一个线程类

    /**
     * 构建我网易云信 POST form 表单请求
     *
     * @param formMap 表单请求参数 Map
     * @param url     IM 请求地址
     * @return
     */
    public String postForm(Map formMap, String url) {
        return HttpRequest.post(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", FORM_CONTENT_TYPE)
                .form(formMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();

    }

    /**
     * 构建我网易云信 POST Josn 请求
     *
     * @param json 请求参数 json
     * @param url  IM 请求地址
     * @return
     */
    public String postJson(JSON json, String url) {
        return HttpRequest.post(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", JSON_CONTENT_TYPE)
                .body(json)//json 对象
                .timeout(20000)//超时，毫秒
                .execute().body();

    }

    public String getForm(Map formMap, String url) {
        return HttpRequest.get(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", FORM_CONTENT_TYPE)
                .form(formMap)//json 对象
                .timeout(20000)//超时，毫秒
                .execute().body();

    }

    public String getForm(String strValue, String url) {
        return HttpRequest.get(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", FORM_CONTENT_TYPE)
                .form(strValue)//json 对象
                .timeout(20000)//超时，毫秒
                .execute().body();

    }

    public String getJson(JSON json, String url) {
        return HttpRequest.get(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", JSON_CONTENT_TYPE)
                .body(json)//json 对象
                .timeout(20000)//超时，毫秒
                .execute().body();

    }

    public String putJson(JSON json, String url) {
        return HttpRequest.put(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", JSON_CONTENT_TYPE)
                .body(json)//json 对象
                .timeout(20000)//超时，毫秒
                .execute().body();
    }

    public String deletJson(JSON json, String url) {
        return HttpRequest.delete(url)
                .header("AppKey", YunXinAPPKey.YUNXIN_APPKEY.getValue())//头信息，多个头信息多次调用此方法即可
                .header("Nonce", CheckSumBuilder.BUILDER.getNonce())
                .header("CurTime", CheckSumBuilder.BUILDER.getCurTime())
                .header("CheckSum", CheckSumBuilder.BUILDER.getCheckSum())
                .header("Content-Type", JSON_CONTENT_TYPE)
                .body(json)//json 对象
                .timeout(20000)//超时，毫秒
                .execute().body();
    }

}
