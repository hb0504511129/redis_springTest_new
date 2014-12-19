package com.hb.redis.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.redis.model.User;
import com.hb.redis.service.UserServiceForRedis;

public class Test {

	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(Test.class); 
    
	public static void main(String[] args) {
	     
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath*:/config/applicationContext.xml");
		UserServiceForRedis userService = (UserServiceForRedis) applicationContext
				.getBean("userService");

		User user1 = new User("user1ID", "User 1");
		User user2 = new User("user2ID", "User 2");

		logger.info("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: "
				+ userService.get(user1));
		System.out.println("User is not in redis yet: "
				+ userService.get(user2));

		logger.info("==== putting objects into redis ====");
		userService.put(user1);
		userService.put(user2);

		logger.info("==== getting objects from redis ====");
		System.out.println("User should be in redis yet: "
				+ userService.get(user1));
		System.out.println("User should be in redis yet: "
				+ userService.get(user2));

		logger.info("==== deleting objects from redis ====");
		userService.delete(user1);
		userService.delete(user2);

		logger.info("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: "
				+ userService.get(user1));
		System.out.println("User is not in redis yet: "
				+ userService.get(user2));
	}

}
