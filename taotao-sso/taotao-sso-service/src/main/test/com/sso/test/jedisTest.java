package com.sso.test;

import com.taotao.jedis.service.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/4/20.
 */
public class jedisTest {

    @Test
    public void test(){

        ApplicationContext tx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xm.xml");

        JedisClient jedisClient = tx.getBean(JedisClient.class);

        jedisClient.set("lbs","123");

        String lb = jedisClient.get("lb");

        System.out.println(lb);
    }

}
