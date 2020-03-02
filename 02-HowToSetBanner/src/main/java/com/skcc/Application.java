package com.skcc;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		
		app.setBanner(new Banner() {

			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				// TODO Auto-generated method stub
				out.println("===================================");
				out.println("끼야호");
				out.println("===================================");
			}
			
		});
		
		
		app.run(args);
		//아래것과 똑같은데,, 아래처럼 사용하면 스프링부트에서 제공해주는 여러가지 기능들을 사용을 못한다.
		//SpringApplication.run(SpringBootApplication1Application.class, args);
	}

}
