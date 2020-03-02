package com.skcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//사용할 수 있는 외부 설정
//● properties
//● YAML
//● 환경 변수
//● 커맨드 라인 아규먼트
//프로퍼티 우선 순위
//1. 유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
//2. 테스트에 있는 @TestPropertySource
//3. @SpringBootTest 애노테이션의 properties 애트리뷰트
//4. 커맨드 라인 아규먼트
//5. SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는
//프로퍼티
//6. ServletConfig 파라미터
//7. ServletContext 파라미터
//8. java:comp/env JNDI 애트리뷰트
//9. System.getProperties() 자바 시스템 프로퍼티
//10. OS 환경 변수
//11. RandomValuePropertySource
//12. JAR 밖에 있는 특정 프로파일용 application properties
//13. JAR 안에 있는 특정 프로파일용 application properties
//14. JAR 밖에 있는 application properties
//15. JAR 안에 있는 application properties
//16. @PropertySource
//17. 기본 프로퍼티 (SpringApplication.setDefaultProperties)

@Component
public class AppRunner implements ApplicationRunner {

	private Logger logger = LoggerFactory.getLogger(AppRunner.class); 

	
	@Value("${youngjae.name}")
	private String name;

	@Autowired
	YoungjaeProperties youngjaeProperties;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.debug("=======================");
		logger.debug(youngjaeProperties.getFullName());
		logger.debug(youngjaeProperties.getName());
		logger.debug("=======================");
		
		
		System.out.println("===============================");
		System.out.println(name);
		System.out.println("===============================");
		//생각을해보면.. 프로퍼티에있는 값들은 전부 문자열인데 int로변환되고 그런다.
		//이거는 applicationContext에 있는 Converter,Formatter인터페이스가 다 알아서 변환을 해주기때문이다.
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println(youngjaeProperties.getAge());
		System.out.println(youngjaeProperties.getFullName());
		System.out.println(youngjaeProperties.getName());
		System.out.println("===============================");
		System.out.println("===============================");
		
		
	}

}
