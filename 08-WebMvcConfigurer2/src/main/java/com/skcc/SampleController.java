package com.skcc;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice이거쓰면 전역에서 처리할 수 있다!
//BasicErrorController 이놈이 처리한다. 컨트롤 쉬프트 티로 검색해서 봐라
@Controller
public class SampleController {

	
	//이거 허용하겠따는거임..원래는 저게 없으면 안됨 
	//근데 모든 요청에 하나하나 이렇게 달수 없으니 컨피크레이션하나만들어보자!
	@CrossOrigin(origins = "http://localhost:18080")
	@GetMapping("/hello")
	public String hello() {
		
		throw new SampleException();		
	}
	
//	아래 다 없애면 500에러발생
	@ExceptionHandler(SampleException.class)
	public @ResponseBody AppError sampleError(SampleException e) {
		AppError appError = new AppError();
		appError.setMessage("에러났어요");
		appError.setReason("원인은몰라요");
		return appError;
		
	}
	 
	
	
//	현재 스프링 부트 공식 페이지 보고 알았네요.
//
//	따라하시는 분들, 아마 Resource 임포트 안되실 겁니다.
//
//	강의 이후에 공식 클래스 이름이 바뀌었나보네요.
//
//	도큐먼트에 다음과 같이 나와있습니다. 참고하세요.
//
//	ResourceSupport is now RepresentationModel
//
//	Resource is now EntityModel
//
//	Resources is now CollectionModel
//
//	PagedResources is now PagedModel
	//여기는 지금 강의내용과 지금 시점이 변경되어서 잘 모르겠다.
	@GetMapping("/hateoas")
	public EntityModel<Test> hateoas(){
		Test test = new Test();
		test.setPrefix("Hey,");
		test.setName("Youngjae");
		
		EntityModel<Test> entityModel = new EntityModel<>(test);
		return entityModel;		
		
	}
}
