package com.tokeys.activemq;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "tokeys.queue")
    public void receiveQueue(Map text) {
        System.out.println(text.toString());
    }
    //  默认Bean的名称就是起方法名  可以可以 指定名称(name="")
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }


    @JmsListener(destination = "tokeys.topic", containerFactory="jmsListenerContainerTopic")
    public void receiveTopic(String text) {
        System.out.println(text);
    }
}
