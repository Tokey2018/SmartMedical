package com.tokeys.im.model;

/**
 * 在线状态
 */
public class OnlineEvent {

    /*accid	String	是	事件订阅人账号*/
    public String accid;

    /*eventType	int	是	事件类型，固定设置为1，即 eventType=1*/
    public int eventType;

    /*publisherAccids	String	是	被订阅人的账号列表，最多100个账号，JSONArray格式。示例：["pub_user1","pub_user2"]*/
    public String publisherAccids;

    /*ttl	long	是	有效期，单位：秒。取值范围：60～2592000（即60秒到30天）*/
    public long ttl;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getPublisherAccids() {
        return publisherAccids;
    }

    public void setPublisherAccids(String publisherAccids) {
        this.publisherAccids = publisherAccids;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
}
