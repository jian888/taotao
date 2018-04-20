package com.taotao.jedis;

import com.taotao.jedis.service.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2018-04-20.
 */
public class JedisTestSpring {
    @Test
    public void testJedisClientPool(){
        //初始化Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
        //从容器中获取JedisClient对象
        JedisClient jedisClient = ctx.getBean(JedisClient.class);
        //使用JedisClient操作Redis
        //jedisClient.set("jedisClient", "mytest");
        jedisClient.set("jedisPool", "mytest");
        String result = jedisClient.get("jedisPool");
        System.out.println(result);
    }
}
