package com.taotao.search.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 接收ActiveMQ发送的消息
 * Created by lenovo on 2018-05-03.
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage)message;
            String text = textMessage.getText();
            System.out.println(text);
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
