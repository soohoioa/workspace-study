package com.itwill.board.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration

public class ApplicationConfig {
	/*
	 application.properties파일의 값얻기위한객체
	 */
	@Autowired
	Environment environment;
	
	
	
	/***************MessageSource객체등록*******************/
	@Bean("messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource=
				new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("messages/board");
		return resourceBundleMessageSource;
	}
	
	
	
	
	
}
