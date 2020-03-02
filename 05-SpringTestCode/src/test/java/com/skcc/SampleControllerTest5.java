package com.skcc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


//slice테스튼데.. 레이어별로 짤라서 테스트하고 싶을 떄 !samplecontroller 하나만 테스트하겠다는거임
//거기에서 필요한 빈만 등록해서 하는 테스트임.(웹과관련된것들만)
//SampleService가 아예 빈으로 등록이 안되기때문에 (그래야 샘플컨트롤러에 autowired가 등록 된 빈을 찾아서 주입할 수 있기때문이다.)
//mock빈으로 등록을 해줘야 한다.
//
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest5 {
	
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
		
	@MockBean
	SampleService mockSampleService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("whiteKim");
		
		mockMvc.perform(get("/hello"))
			.andExpect(content().string("HellowhiteKim"));
		
		assertThat(outputCapture.toString())
			.contains("TEST")
			.contains("skip");
		
	}

}