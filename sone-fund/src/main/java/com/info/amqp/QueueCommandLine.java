package com.info.amqp;

import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;


@Component
public class QueueCommandLine implements CommandLineRunner{
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("bingding...");
		Connection connection = connectionFactory.createConnection();
		Channel channel = connection.createChannel(true);
		channel.exchangeDeclare("test6", "direct");
		channel.queueDeclare("test6", true, false, false, null);
		channel.queueBind("test6", "test6", "test6");
		
	}

}
