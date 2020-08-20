package com.example.demo.rabbitmq.routing.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
	private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
	private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
	private static final String EXCHANGE_ROUTING_INFORM = "exchange_routing_inform"; 

	
	public static void main(String[] args) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("127.0.0.1");
			factory.setPort(5672);
			factory.setUsername("guest");
			factory.setPassword("guest");
			factory.setVirtualHost("/");
		
			connection = factory.newConnection();
			channel = connection.createChannel();
			
			/**
			 *  fanout 发布订阅模式
			 *  direct Routing
			 *  topic  Topics
			 *  headers Headers
			 */
			channel.exchangeDeclare(EXCHANGE_ROUTING_INFORM, BuiltinExchangeType.DIRECT);
			
			channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);
			channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
			
			// 队列绑定交换机 交换机根据路由key的值将消息转发到指定的队列中给
			channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_SMS);
			channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_EMAIL);
			
			for(int i = 0; i<10;i++) {
				String message = "sms inform message to user" + i;
				
//				  *  @see <a href="http://www.rabbitmq.com/alarms.html">Resource-driven alarms</a>
//				     * @param exchange the exchange to publish the message to
//				     * @param routingKey the routing key
//				     * @param props other properties for the message - routing headers etc
//				     * @param body the message body
//				     * @throws java.io.IOException if an error is encountered
				channel.basicPublish(EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_SMS, null, message.getBytes());
				
				String message1 = "email inform message to user" + i;
				channel.basicPublish(EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_EMAIL, null, message1.getBytes());

				System.out.println("Send Message is: " + message);
			}
			
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(channel != null) {
				try {
					channel.close();
				} catch (IOException | TimeoutException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
