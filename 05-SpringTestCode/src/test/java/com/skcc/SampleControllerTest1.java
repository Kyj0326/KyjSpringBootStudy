package com.skcc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

//근데 이렇게하면 테스트가 너무크고 특정 서비스만 테스트하고싶다..
//내장톰켓구동하여 랜덤포트 뜸
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest1 {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void hello() {
		String result = testRestTemplate.getForObject("/hello" , String.class);
		assertThat(result).isEqualTo("HelloYOUNGJAE");
		
		
	}

}
