package com.skcc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//HttpMessageConverters가 사용이 된다.(객체가 유입되면 객체를 알아서 컨버터해서 매핑시킨다.)
//스프링 mvc의 기능 중 하나다.
//사용되는 컨버터는 그떄그때 다르다.
//요청에는 컨텐츠 타입의 해더가 있는데 컨텐츠타입에 제이슨이라고 적혀있고 제이슨데이터가 유입되면제이슨 컨버터가 사용된다.
//제이슨 객체를 유저라는 객체로 컨버팅해준다.
//기본적으로는 제이슨메시지컨버터가 사용 됨.!컴포지션타입일떄(객체에 다양한 프로퍼티가 있는경우)
//그냥 리턴타입이 String이다! 그럼 스트링메시티컨버터가 사용이된다.
//
@RestController
public class SampleController {
	//@ResponseBody이게 지금 아래에 있는거임 //생략해도됨 @ RestController일때는 
	//그냥 @Controller를 사용 할 경우에는  꼭 붙여줘야함
	//그러지 않으면 viewResolver를 사용해서 hello에 해당하는 view를 찾으려고 시도한다.
	@GetMapping("/hello")
	public @ResponseBody String hello() {
		return "hello";
	}
	//@ResponseBody 이거 생략해도된다. RestController기때문에! 
	@PostMapping("/users/create")
	public @ResponseBody User create(@RequestBody User user) {
		return user;
	}
			

}
