package com.tokeys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
@Configuration
@EnableCaching
@PropertySource("classpath:user.properties")// 用来指定配置文件的位置
@ComponentScan(basePackages = {"com.tokeys","com.ibeetl.admin"})
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
