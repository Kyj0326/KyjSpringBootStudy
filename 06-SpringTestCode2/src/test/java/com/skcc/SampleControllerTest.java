package com.skcc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.xpath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void hello() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("hello"));
	}
	
	@Test
	public void createUser_JSON() throws Exception {
		
		String userJson= "{\"username\":\"youngjae\", \"password\":\"123\"}";
		
		mockMvc.perform(post("/users/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8) //컨텐츠타입은뭘로할꺼냐? 
				.accept(MediaType.APPLICATION_JSON_UTF8) //응답으로 어떤걸원하느냐?
				.content(userJson))//요청본문에는 뭘넣을거냐 
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.username", is(equalTo("youngjae"))))
		.andExpect(jsonPath("$.password", is(equalTo("123"))));
				
	}
	
	@Test
	public void createUser_XML() throws Exception {
		
		String userJson= "{\"username\":\"youngjae\", \"password\":\"123\"}";
		
		mockMvc.perform(post("/users/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8) //컨텐츠타입은뭘로할꺼냐? 
				.accept(MediaType.APPLICATION_XML) //응답으로 어떤걸원하느냐?
				.content(userJson))//요청본문에는 뭘넣을거냐 
		.andExpect(status().isOk())
		.andExpect((ResultMatcher) xpath("/User/username").string("youngjae"))
		.andExpect((ResultMatcher) xpath("/User/password").string("123"));
			//뭔가 스프링에 업데이트가 생긴듯?안되네..
		//여기선 핵심은 xml로 응답을 해주고싶을땐 xml컨버터를 의존성에 추가해서 변경하면 할 수 있다 뭐그런얘기다. 
	}
	

}
