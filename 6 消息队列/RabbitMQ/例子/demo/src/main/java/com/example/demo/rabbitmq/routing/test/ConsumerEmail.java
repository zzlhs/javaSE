package com.example.demo.rabbitmq.routing.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class ConsumerEmail {
	private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
	private static final String EXCHANGE_ROUTING_INFORM = "exchange_routing_inform"; 
	
	public static void main(String[] args) {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("127.0.0.1");
			factory.setPort(5672);
			factory.setUsername("guest");
			factory.setPassword("guest");
			factory.setVirtualHost("/");
			
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			channel.exchangeDeclare(EXCHANGE_ROUTING_INFORM, BuiltinExchangeType.DIRECT);
			
			channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
			
			channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_EMAIL);
			DefaultConsumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, 
						Envelope envelope, 
						BasicProperties properties,
						byte[] body) throws IOException {
					// 交换机
					String exchange = envelope.getExchange();
					// 消息id mq再channel中用来标识消息的id，可用于确认消息已接收
					long deliveryTag = envelope.getDeliveryTag();
					String msg = new String(body, "utf-8");
					System.out.println("接收的消息： " + msg);
				}
			};
			channel.basicConsume(QUEUE_INFORM_EMAIL, true, consumer);
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}
