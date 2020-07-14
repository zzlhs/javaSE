package com.example.demo.rabbitmq.work_queue.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer01 {
	
	private static final String QUEUE = "hello world";
	
	public static void main(String[] args) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("127.0.0.1");
			factory.setPort(5672);
			factory.setUsername("guest");
			factory.setPassword("guest");
			factory.setVirtualHost("/"); // rabbitmq默认虚拟机名称为 / ,虚拟机相当于一个独立的mq服务
		
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE, true, false, false, null);
			
			String message = "helloworld zyf" + System.currentTimeMillis();
			/**
			 *   * @param exchange the exchange to publish the message to
			     * @param routingKey the routing key
			     * @param props other properties for the message - routing headers etc
			     * @param body the message body
			 */
			for(int i = 0;i<10;i++) {
				message = (i+1) + "helloworld zyf" + System.currentTimeMillis();
				channel.basicPublish("", QUEUE, null, message.getBytes());
				System.out.println("发送的消息： " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}finally {
			try {
				if(channel != null) {
					channel.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (IOException | TimeoutException e) {
				e.printStackTrace();
			}
		}
	}
}
