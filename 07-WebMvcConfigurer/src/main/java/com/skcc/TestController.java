package com.skcc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	//이제 밑에 리턴 hello는 모델을 찾아가는거임
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","youngjae");
		return "hello";
	}
	
	

}
