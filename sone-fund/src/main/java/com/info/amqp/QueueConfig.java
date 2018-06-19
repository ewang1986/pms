package com.info.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.BindingFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfig {
	
	@Bean
	public Queue test1() {
		Queue test1 = new Queue("test3");
		return test1;
	}
	
	@Bean
	public DirectExchange test1Change() {
		return new DirectExchange("test3");
	}
	
	@Bean
	public Binding bindingTest1() {
		return BindingBuilder.bind(new Queue("test3")).
				to(new DirectExchange("test3")).with("test3");
	}
	
	
	
}
