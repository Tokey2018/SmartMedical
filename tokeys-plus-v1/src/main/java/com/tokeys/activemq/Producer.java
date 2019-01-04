package com.tokeys.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.HashMap;
import java.util.Map;

/**
 * 参考 ：https://blog.csdn.net/xiaoluo5238/article/details/81202642
 */
@RequestMapping("/api2")
@RestController
public class Producer {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("tokeys.queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("tokeys.topic");
    }

    @Bean
    public ConnectionFactory connectionFactory() {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //FIXME 应该放到配置文件中初始化

        //connectionFactory.setBrokerURL("tcp://www.ju*****.com:61616");
        return connectionFactory;
    }

   /* @Bean
    public JmsTemplate genJmsTemplate() {
        return new JmsTemplate(connectionFactory());

    }*/

    @Bean(name = "jmsMessagTemplate")
    public JmsMessagingTemplate jmsMessagTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
        // return new JmsMessagingTemplate(genJmsTemplate());

    }

    //新版本的jsmTemplate同时支持queue和topic发送
    @Autowired
    private JmsMessagingTemplate jmsMessagTemplate;
    //private  JmsMessagingTemplate jmsMessagingTemplate;


    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;


    @GetMapping("/sendMsg")
    public void send(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", msg);
        this.jmsMessagTemplate.convertAndSend(this.queue, map);


    }

    @GetMapping("/sendTopic")
    public void sendTopic(String msg) {
        this.jmsMessagTemplate.convertAndSend(this.topic, msg);

    }
}
