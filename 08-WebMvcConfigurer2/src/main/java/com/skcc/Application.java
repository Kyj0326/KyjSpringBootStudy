package com.skcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//SOP과 CORS
//Single-Origin Policy
//Cross-Origin Resource Sharing
//Origin?
//URI 스키마 (http, https)
//hostname (whiteship.me, localhost)
//포트 (8080, 18080)
//스프링 MVC @CrossOrigin
//https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#mvc-cors
//@Controller나 @RequestMapping에 추가하거나
//WebMvcConfigurer 사용해서 글로벌 설정
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
