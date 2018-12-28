package com.tokeys.im.util;

/**
 * Created by Administrator on 2018/12/13.
 * HttpClientUtil 该类要不要做成单例 。必须做成单利
 * http 连接池
 * 线程池执行?
 * 当使用了请求连接池管理器（比如PoolingClientConnectionManager）后，HttpClient就可以同时执行多个线程的请求了。
 * https://www.yeetrack.com/?p=782
 * 即使HttpClient的实例是线程安全的，可以被多个线程共享访问，但是仍旧推荐每个线程都要有自己专用实例的HttpContext。
 *
 */
public class HttpClientUtil {
    /**
     *批量添加好友是一个线程类
     */


}
