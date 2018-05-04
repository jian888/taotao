package com.taotao.activemq;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/**
 * 接受消息测试
 * Created by lenovo on 2018-05-03.
 */
public class TestSpringActiveMQ {
    @Test
    public void testActiveMQConsumer() throws IOException{
        //初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
        //等待接收消息
        System.in.read();
    }

    /**
     * 集合去重
     */
    @Test
    public void test(){
        /*Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(3);
        vector.add(4);
        vector.add(4);
        for (Integer i:vector) {
            System.out.print(i);
        }*/
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(7);
        list.add(7);
        for (Integer i:list) {
            System.out.print(i);
        }
        System.out.print("\n");
        HashSet<Integer> integers = new HashSet<>(list);
        for (Integer i:integers) {
            System.out.print(i);
        }
    }
}
