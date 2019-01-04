package com.tokeys.im.util;

import cn.hutool.core.bean.BeanUtil;
import com.tokeys.im.enums.YunXinIMApi;
import com.tokeys.im.model.IMUser;

import java.util.Map;

public class HttpClientUtilTest {
    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {

            Thread thread = new POSTForm("我是线程=" + i);
            thread.start();

        }

    }
}


/**
 * 模拟多线程并发
 */
class POSTForm extends Thread {
    public POSTForm(String name) {

    }


    @Override
    public void run() {
        IMUser u = new IMUser();
        // 20161115289336n3 我已经注册过得网易云信id
        u.setAccid("20161115289336n3");
        Map map = BeanUtil.beanToMap(u);
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "返回结果 =" + HttpClientUtil.INSTANCE.postForm(map, YunXinIMApi.USER_CREATE.getApi()));

    }


}

