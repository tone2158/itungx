package com.example.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock{
    public static void main(String[] args){
        Ticket ticket = new Ticket();

        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();
    }
}

/*class Ticket implements Runnable{

    private int tick = 100;

    public void run(){
        while(true){
            if(tick > 0){
                try{
                    Thread.sleep(200);
                }catch(InterruptedException e){

                }

                System.out.println(Thread.currentThread().getName()+"完成售票,余票为: "+ --tick);
            }
        }
    }
}*/

// 使用 Lock
class Ticket implements Runnable{

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    public void run(){
        while(true){
            // 上锁
            lock.lock();

            try{
                if(tick > 0){
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){

                    }
                    System.out.println(Thread.currentThread().getName()+"完成售票,余票为: "+ --tick);
                }
            }finally{
                // 释放锁
                lock.unlock();
            }
        }
    }
}
