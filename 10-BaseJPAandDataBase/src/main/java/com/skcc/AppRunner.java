package com.skcc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		try(Connection connection = dataSource.getConnection()){
			Account account = new Account();
			account.setUsername("youngjae");
			account.setPassword("1234");
			accountRepository.save(account);
			System.out.println(connection.getMetaData().getClass());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println("결과값 " + accountRepository.findByUsername("youngjae").toString());
		}
		
		
	}
	

}
