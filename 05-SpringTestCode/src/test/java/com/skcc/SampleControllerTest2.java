package com.skcc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest2 {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@MockBean
	SampleService mockSampleService;
	
	@Test
	public void hello() {
		when(mockSampleService.getName()).thenReturn("whiteKim");
		
		String result = testRestTemplate.getForObject("/hello" , String.class);
		assertThat(result).isEqualTo("HellowhiteKim");
		
		
	}

}