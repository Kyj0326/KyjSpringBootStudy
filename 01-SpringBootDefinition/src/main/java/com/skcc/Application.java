package com.skcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//어떻게 하여 이많은 의존성이 들어왔는가,
// -> pom.xml에서 다 정의를 해놓았다.. 의존성관리를 해준다는거는 우리가 해야할 일이 줄어든다는것이다.!
//  버전을 올려야한다,, 그러면 영향도검토하는데 토나온다!
//어떻게하여 컨테이너에 빈들이 생성되어서 서로 의존관계를 갖는가를 알아보자..
// -> 
//런을 했을 때 어떻게 동작을 하는거냐


//빈을 두단계에 걸쳐서 등록을 함
//Componentscan으로 @Component
// @Configuration @Repository @Service @Controller @RestController 달려있는 빈들을 등록하고!
// @EnableAutoConfiguration로 빈등록한다@ 
// 메이븐 dependency에 당겨져온 소스중에
//■ org.springframework.boot.autoconfigure.EnableAutoConfiguation
//안에 spring.factories 를보면 컨피그레이션 정보들이 (스프링부트가 제공하는 컨벤션들)이 정의되어있다.
//모든 클래스들에는 configuration이 달려이따.
//근데 각각은 조건들이 다있다.! 빈으로 등록될지 안될지..
//그중에 ServletWebServerFactoryAutoConfiguration을 보자  이게 웹서버를띄워주는거임!
//DispatcherServletAutoConfiguration는 서블릿을 만들어줌!
// 스프링의 MVC의 핵심 DispatcherServlet임!
//실질적으로 @EnableAutoConfiguration는 없어도 부트는 동작 함.
//@SpringBootApplication
@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
//이 3가지 어노테이션을 다 사용하는게 @SpringBootApplication이거 하나쓰는거랑 같은거임 
public class Application {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
		
		//SpringApplication.run(SpringApplication9Application.class, args); 
		//@EnableAutoConfiguration을 주석처리하고 이부분을 실행하면 웹애플리케이션으로 만들려고 하기때문에 수행이 안됨
		//왜냐하면 @EnableAutoConfiguration에 웹관련 빈정보가 있기때문임.
		    
	}

}
