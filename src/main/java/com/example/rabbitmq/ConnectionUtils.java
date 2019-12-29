package com.example.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("122.51.108.71");
        factory.setPort(5672);
        factory.setVirtualHost("/vhost");
        factory.setUsername("itung");
        factory.setPassword("123");
        return factory.newConnection();
    }

}
