package com.hb.redis.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.hb.redis.model.User;

@Service("userService")
public class UserServiceForRedis {

	@Autowired
	@Qualifier("redisTemplate")
	RedisTemplate<String, User> redisTemplate;

	public RedisTemplate<String, User> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(User user) {
		redisTemplate.opsForHash()
				.put(user.getObjectKey(), user.getKey(), user);
	}

	public void delete(User key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	public User get(User key) {
		return (User) redisTemplate.opsForHash().get(key.getObjectKey(),
				key.getKey());
	}
}