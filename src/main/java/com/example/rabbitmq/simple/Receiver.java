package com.example.rabbitmq.simple;

import com.example.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receiver {
    private static final String SIMPLE_QUE = "I`m SIMPLE_QUE";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(SIMPLE_QUE,false,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("msg"+msg);
            }
        };

        //自动确认
        boolean autoAck = true;
        channel.basicConsume(SIMPLE_QUE, autoAck, defaultConsumer);
    }
}
