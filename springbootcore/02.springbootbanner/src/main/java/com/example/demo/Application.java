package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootBannerApplication.class, args);
		SpringApplication sa = new SpringApplication (Application.class);
		 //sa.setBannerMode(Banner.Mode.OFF); //to Disable the banner
		 //sa.setBannerMode(Banner.Mode.CONSOLE); //to Disable the banner on console
		 sa.setBannerMode(Banner.Mode.LOG); //to Display the banner in Log file
		 //some other configuration
		 ConfigurableApplicationContext c = sa.run(args);
		 System.out.println(c.getClass().getName().toString());
	}

}
