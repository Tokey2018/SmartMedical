package com.tokeys.im.model;

/**
 * 网易云信 历史信息
 */
public class HistoryMsg {

    /*from	String	是	发送者accid*/
    public String from;

    /*    to	String	是	接收者accid*/
    public String to;

    /*begintime	String	是	开始时间，ms*/
    public String begintime;

    /*endtime	String	是	截止时间，ms*/
    public String endtime;

    /*limit	int	是	本次查询的消息条数上限(最多100条),小于等于0，或者大于100，会提示参数错误*/
    public int limit;

    /*reverse	int	否	1按时间正序排列，2按时间降序排列。其它返回参数414错误.默认是按降序排列*/
    public int reverse;

    /*  type	String	否	查询指定的多个消息类型，类型之间用","分割，不设置该参数则查询全部类型消息格式示例： 0,1,2,3
      类型支持： 1:图片，2:语音，3:视频，4:地理位置，5:通知，6:文件，10:提示，11:Robot，100:自定义*/
    public String type;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getReverse() {
        return reverse;
    }

    public void setReverse(int reverse) {
        this.reverse = reverse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
