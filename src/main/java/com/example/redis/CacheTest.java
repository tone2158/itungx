package com.example.redis;

import com.example.redis.LinkedListCache;

public class CacheTest {

    public static void main(String[] args) throws InterruptedException {
        
        LinkedListCache<String> linkedListCache = new LinkedListCache<String>(100);

        linkedListCache.put("1");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("2");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("3");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("4");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("5");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("1");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("6");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("4");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("7");
        System.out.println(linkedListCache.toString());
    }
}
//原文链接：https://blog.csdn.net/u011763190/article/details/47343153