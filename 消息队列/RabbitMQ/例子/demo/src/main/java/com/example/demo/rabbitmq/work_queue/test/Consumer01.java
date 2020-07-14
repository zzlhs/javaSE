package com.example.demo.rabbitmq.work_queue.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Consumer01 {
	
	private static final String QUEUE = "hello world";
	
	public static void main(String[] args) {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("127.0.0.1");
			factory.setPort(5672);
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			/**
			     * @param queue the name of the queue
			     * @param durable true if we are declaring a durable queue (the queue will survive a server restart)
			     * @param exclusive true if we are declaring an exclusive queue (restricted to this connection)
			     * @param autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
			     * @param arguments other properties (construction arguments) for the queue
			     * @return a declaration-confirm method to indicate the queue was successfully declared
			 */
			channel.queueDeclare(QUEUE, true, false, false, null);
			DefaultConsumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, 
						Envelope envelope, 
						BasicProperties properties,
						byte[] body) throws IOException {
					super.handleDelivery(consumerTag, envelope, properties, body);
					String exchange = envelope.getExchange();
					String routingKey = envelope.getRoutingKey();
					long deliveryTag = envelope.getDeliveryTag();
					String msg = new String(body, "utf-8");
					System.out.println("接收的消息： " + msg);
				}
			};
			channel.basicConsume(QUEUE, true, consumer);
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}
