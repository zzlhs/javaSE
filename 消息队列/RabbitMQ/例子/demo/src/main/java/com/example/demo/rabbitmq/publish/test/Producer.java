package com.example.demo.rabbitmq.publish.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
	private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
	private static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform"; 
	
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
			channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);
			
			channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);
			channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
			
			/**
			 *   * @param queue the name of the queue
			     * @param exchange the name of the exchange
			     * @param routingKey the routine key to use for the binding
			 */
			// 队列绑定交换机 交换机根据路由key的值将消息转发到指定的队列中给
			channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_FANOUT_INFORM, "");
			channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_FANOUT_INFORM, "");
			
			for(int i = 0; i<10;i++) {
				String message = "inform message to user" + i;
				channel.basicPublish(EXCHANGE_FANOUT_INFORM, "", null, message.getBytes());
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
