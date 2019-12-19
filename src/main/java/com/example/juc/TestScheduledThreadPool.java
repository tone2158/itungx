package com.example.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool{

    public static void main(String[] args) throws Exception{
        // 1. 创建线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        // 2. 分配任务
        //      pool.shedule(Callalbe<T> callable, long delay, TimeUnit unit(时间单位))

        for(int i=0; i < 10; i++){
            Future<Integer> result = pool.schedule(new Callable<Integer>(){

                public Integer call() throws Exception{
                        // 产生100以内的随机数
                        int num = new Random().nextInt(100);

                        System.out.println(Thread.currentThread().getName()+ ":" + num);

                        return num;
                    }
                }, 3, TimeUnit.SECONDS);

                System.out.println(result.get());
        }

        //3. 关闭线程池
        pool.shutdown();
    }
}
