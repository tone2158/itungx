package com.example.rabbitmq.workfair;

import com.example.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 轮询分发
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //每个消费者发送确认消息之前，消息队列不发送下一个消息到消费队列，一次只处理一个消息
        channel.basicQos(1);
        for (int i = 0; i < 50; i++) {
            String msg = "hello"+i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(i*20);
        }
        channel.close();
        connection.close();

    }
}
