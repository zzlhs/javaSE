package com.zzl.rabbit.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.zzl.rabbit.config.RabbitmqConfig;

@Component
public class ReceiveHandler {

//	, Message msg, Channel channel
	@RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
	public void receiveEmail(String message) {
		System.out.println("收到的消息 " + message);
	}
	
//	, Message msg, Channel channel
	@RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
	public void sendSms(String message) {
		System.out.println("收到的消息 " + message);
	}
}
