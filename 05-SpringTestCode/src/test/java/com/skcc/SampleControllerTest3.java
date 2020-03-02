package com.skcc;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

//restClient는.. 싱크방식인데
//webclient는 어싱크방식임 
//SpringBootTest 어노테이션이 SpringBootApplication 을 찾아가서 모든 빈을 찾아가서
//단위테스트용 어플리케이션택스트를 만들어서  모든빈을 단위테스트용으로 등록하고,
//그다음에 mockbean을 찾아서 그 빈만 mock으로 교체해준다. 
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest3 {
	
	@Autowired
	WebTestClient webTestClient;
	
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