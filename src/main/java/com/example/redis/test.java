package com.example.redis;


import redis.clients.jedis.Jedis;

import java.util.List;

public class test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("175.24.8.25",6379);
        System.out.println("connect successfully");
        // 如果设置了认证，就需要认证一下
        //jedis.auth("123456");
        System.out.println("Server is running: "+jedis.ping());
        // push值
        jedis.lpush("hello", "wy","hhhhh","licon","jsp");
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        List<String> list = jedis.lrange("hello",0,5);
        list.forEach(s -> System.out.println("value:"+s));
    }
}
//原文链接：https://blog.csdn.net/qq_31987435/article/details/82595051