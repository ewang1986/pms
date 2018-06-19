package com.info.amqp;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听queues=message的消息
 * @author v-dongdm
 *
 */
@Component
public class MessageReceiver {
	

	@RabbitListener(queues = "message")
	@RabbitHandler
	public void process(Message message) {
		if(null == message) return ;
		try {
			String body = new String(message.getBody(),"utf-8");
			System.out.println("接收到消息：" + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	@RabbitListener(queues = "test1")
	@RabbitHandler
	public void processTest1(Message message) {
		if(null == message) return ;
		try {
			String body = new String(message.getBody(),"utf-8");
			System.out.println("接收到消息：" + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
