package com.example.rabbitmq.simple;

import com.example.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Sender {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建消息通道
        Channel channel = connection.createChannel();
        /**
         * queue 队列名称
         * durable 是否持久化,是的话会将次队列持久化保存到Erlang自带的Mnesia数据库中，RabbitMQ重启后会读取该数据库
         *    	   (注意，该参数只是持久化队列，并非消息，想要确保消息的可靠性，必须要将消息也进行持久化设置)
         * exclusive 是否为排他队列  1：connection关闭时,该队列是否自动删除，2：该队列是否私有
         *           当设置为true的时候，一个队列只允许一个消费者，一般情况设置为false
         * autoDelete 是否自动删除，当最后一个消费者断开连接之后队列是否自动被删除，
         *            可以通过RabbitMQ Management，查看某个队列的消费者数量，当consumers = 0时队列就会自动删除
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        /**
         * 发送消息
         *
         * exchange 交换机名称
         * routingKey 路由关键字
         * props 未做研究,只知道这里可以设置消息持久化  MessageProperties.PERSISTENT_TEXT_PLAIN
         * body 消息
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        channel.close();
        connection.close();
    }
}
