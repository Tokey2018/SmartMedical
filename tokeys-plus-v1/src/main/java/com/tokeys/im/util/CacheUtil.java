package com.tokeys.im.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * EhCache 缓存
 * Created by Administrator on 2019/01/01.
 */

@Component
public class CacheUtil {

    @Autowired
    private EhCacheCacheManager ehCacheCacheManage;

    /**
     *  FIXME 多线程时加锁 是否必要,不加锁 可以配置 @Component(value = "singleton=“false”")
     * @param cacheName
     * @param key
     * @param value
     */
    public void put(String cacheName, Object key, Object value) {
        synchronized (this){
            ehCacheCacheManage.getCache(cacheName).put(key, value);
        }

    }

    public Cache getCache(String cacheName) {
        return ehCacheCacheManage.getCache(cacheName);
    }

    public String getValue(String cacheName, Object key) {
        if (null != cacheName && null != key) {
            return ehCacheCacheManage.getCache(cacheName).get(key).get().toString();
        } else
            return null;

    }
}
