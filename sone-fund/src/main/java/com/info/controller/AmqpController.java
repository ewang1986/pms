package com.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.amqp.MessageSender;
import com.info.util.Result;

/**
 * 定义rabbitMq的操作
 * @author v-dongdm
 *
 */
@RestController
@RequestMapping("/amqp")
public class AmqpController {
	
	@Autowired
	private MessageSender sender;
	
	@RequestMapping("/sendMes")
	public Result sendMessage(@RequestParam("mes") String mes){
		sender.send(mes);
		return new Result();
	}
	
	@RequestMapping("/sendTest1")
	public Result sendTest1(@RequestParam("mes") String mes){
		sender.sendTest1(mes);
		return new Result();
	}
	
	@RequestMapping("/sendTest2")
	public Result sendTest2(@RequestParam("mes") String mes){
		sender.sendTest2(mes);
		return new Result();
	}

}
