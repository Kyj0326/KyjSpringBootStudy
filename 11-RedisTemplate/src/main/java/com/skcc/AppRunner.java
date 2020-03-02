package com.skcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner{
	
	@Autowired
	StringRedisTemplate redisTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		ValueOperations<String, String> values = redisTemplate.opsForValue();
		values.append("1", "TEST");
		values.append("2", "33ST");
		values.append("3", "4433ST");
		
		
		
	}
	
	

}
