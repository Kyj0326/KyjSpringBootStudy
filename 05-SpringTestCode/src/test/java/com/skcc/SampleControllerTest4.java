package com.skcc;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class SampleControllerTest4 {
	
	@Autowired
	JacksonTester<여기다가 등록해서..>
	
	@MockBean
	SampleService mockSampleService;
	
	@Test
	public void hello() {
		when(mockSampleService.getName()).thenReturn("whiteKim");
		
		webTestClient.get().uri("/hello").exchange()
			.expectStatus().isOk()
			.expectBody(String.class).isEqualTo("HellowhiteKim");
		
		
		
	}

}