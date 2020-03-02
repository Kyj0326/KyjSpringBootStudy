package com.skcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.addListeners(new SampleListner());
		app.run(args);
		
		//SpringApplication.run(SpringBootApplication2Application.class, args);
	}

}
