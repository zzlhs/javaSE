package com.zzl.rabbit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzl.rabbit.config.RabbitmqConfig;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoRabbitMqApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSendByTopics() {
		for(int i = 0 ;i<5;i++) {
			String message = "sms email inform to user " + i;
			rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM, 
					"inform.sms.email", message);
			System.out.println(message);
		}
		System.out.println("123");
	}

}
