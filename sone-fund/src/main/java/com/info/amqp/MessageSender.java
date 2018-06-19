package com.info.amqp;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 向queues=message发送消息
 * @author v-dongdm
 *
 */
@Component
public class MessageSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(String mes){
		String content = mes + new Date();
		System.out.println("send:" + content);
		MessageProperties pro = new MessageProperties();
		Message message;
		try {
			message = new Message(content.getBytes("utf-8"),pro);
			this.rabbitTemplate.send("test","test", message);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendTest1(String mes){
		String content = mes + new Date();
		System.out.println("send:" + content);
		MessageProperties pro = new MessageProperties();
		Message message;
		try {
			message = new Message(content.getBytes("utf-8"),pro);
			this.rabbitTemplate.send("test1","test1", message);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendTest2(String mes){
		String content = mes + new Date();
		System.out.println("send:" + content);
		MessageProperties pro = new MessageProperties();
		Message message;
		try {
			message = new Message(content.getBytes("utf-8"),pro);
			this.rabbitTemplate.send("test2","test2", message);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
