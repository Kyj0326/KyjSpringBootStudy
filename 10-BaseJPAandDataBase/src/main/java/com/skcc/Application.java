package com.skcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//JPA를 사용한 데이터베이스 초기화
//spring.jpa.hibernate.ddl-auto
//spring.jpa.generate-dll=true로 설정 해줘야 동작함.
//  SQL 스크립트를 사용한 데이터베이스 초기화
//schema.sql 또는 schema-${platform}.sql
//data.sql 또는 data-${platform}.sql
//${platform} 값은 spring.datasource.platform 으로 설정 가능.




//휘발성인 메모리디비 h2쓰지않고 다른거쓸데 좋다~ 
//Flyway와 Liquibase가 대표적인데, 지금은 Flyway를 사용하겠습니다. https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup
//의존성 추가
//org.flywaydb:flyway-core
//마이그레이션 디렉토리
//db/migration 또는 db/migration/{vendor}
//spring.flyway.locations로 변경 가능
//마이그레이션 파일 이름
//V숫자__이름.sql
//V는 꼭 대문자로.
//숫자는 순차적으로 (타임스탬프 권장)
//숫자와 이름 사이에 언더바 두 개.
//이름은 가능한 서술적으로.