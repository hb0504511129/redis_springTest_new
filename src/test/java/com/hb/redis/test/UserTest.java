package com.hb.redis.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hb.redis.model.User;
import com.hb.redis.service.UserServiceForRedis;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/applicationContext.xml.xml",
//		"classpath:config/redis-context.xml" })
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class UserTest {
	
	@Autowired
	private  UserServiceForRedis userService ;
	
	@Test
	public void userServerTest() {
		
		User user1 = new User("user1ID", "User 1");  
        User user2 = new User("user2ID", "User 2");  
          
        System.out.println("==== getting objects from redis ====");  
        System.out.println("User is not in redis yet: " + userService.get(user1));  
        System.out.println("User is not in redis yet: " + userService.get(user2));  
          
        System.out.println("==== putting objects into redis ====");  
        userService.put(user1);  
        userService.put(user2);  
          
        System.out.println("==== getting objects from redis ====");  
        System.out.println("User should be in redis yet: " + userService.get(user1));  
        System.out.println("User should be in redis yet: " + userService.get(user2));  
          
        System.out.println("==== deleting objects from redis ====");  
        userService.delete(user1);  
        userService.delete(user2);  
          
        System.out.println("==== getting objects from redis ====");  
        System.out.println("User is not in redis yet: " + userService.get(user1));  
        System.out.println("User is not in redis yet: " + userService.get(user2));  
  
		
	}

}
