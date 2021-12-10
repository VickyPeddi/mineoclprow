package com.iocl.dhruva2api;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@SpringBootApplication
//public class Dhruva2ApiApplication {
//
//	@PostConstruct
//	void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Dhruva2ApiApplication.class, args);
//	}
//}

//allow this for WAR.

@SpringBootApplication
public class Dhruva2ApiApplication extends SpringBootServletInitializer {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Dhruva2ApiApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Dhruva2ApiApplication.class, args);

	}
}