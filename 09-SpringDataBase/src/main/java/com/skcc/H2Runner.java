package com.skcc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class H2Runner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	
	//이거는 너무좋은거다!
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	//mysql로 바꿧다고 소스가 바뀌진않는다 (문법은바귈수도있찌만)
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("여기는요");
		Connection connection = dataSource.getConnection();
		System.out.println(connection.getClass());
		System.out.println("여기요");
		System.out.println(connection.getMetaData().getDriverName());
		System.out.println(connection.getMetaData().getURL());
		System.out.println(connection.getMetaData().getUserName());
		
		Statement statement = connection.createStatement();
		String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
		statement.execute(sql);
		
		jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'youngjae')");
		
	}
	
	

}
//지원하는 DBCP
//HikariCP (기본)
//https://github.com/brettwooldridge/HikariCP#frequently-used
//Tomcat CP
//Commons DBCP2
//DBCP 설정
//spring.datasource.hikari.*
//spring.datasource.tomcat.*
//spring.datasource.dbcp2.*
//MySQL 커넥터 의존성 추가
//<dependency>
//   <groupId>mysql</groupId>
//   <artifactId>mysql-connector-java</artifactId>
//</dependency>
//MySQL 추가 (도커 사용)
//docker run -p 3306:3306 --name mysql_boot -e MYSQL_ROOT_PASSWORD=1 -e MYSQL_DATABASE=springboot -e MYSQL_USER=keesun -e MYSQL_PASSWORD=pass -d mysql
//docker exec -i -t mysql_boot bash
//mysql -u root -p
//MySQL용 Datasource 설정
//spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useSSL=false
//spring.datasource.username=keesun
//spring.datasource.password=pass
//MySQL 접속시 에러
//MySQL 5.* 최신 버전 사용할 때
//문제	Sat Jul 21 11:17:59 PDT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
//해결	jdbc:mysql:/localhost:3306/springboot?useSSL=falseMySQL 8.* 최신 버전 사용할 때
//문제	com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Public Key Retrieval is not allowed
//해결	jdbc:mysql:/localhost:3306/springboot?useSSL=false&allowPublicKeyRetrieval=trueMySQL 라이센스 (GPL) 주의
//MySQL 대신 MariaDB 사용 검토
//소스 코드 공개 의무 여부 확인















//postsql임

//의존성 추가
//<dependency>
//   <groupId>org.postgresql</groupId>
//   <artifactId>postgresql</artifactId>
//</dependency>
//PostgreSQL 설치 및 서버 실행 (docker)
//docker run -p 5432:5432 -e POSTGRES_PASSWORD=pass -e POSTGRES_USER=keesun -e POSTGRES_DB=springboot --name postgres_boot -d postgres
//
//docker exec -i -t postgres_boot bash
//
//su - postgres
//
//psql springboot
//
//데이터베이스 조회
//\list
//
//테이블 조회
//\dt
//
//쿼리
//SELECT * FROM account;
//PostgreSQL 경고 메시지
//경고 :  org.postgresql.jdbc.PgConnection.createClob() is not yet implemented 해결 :  spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
