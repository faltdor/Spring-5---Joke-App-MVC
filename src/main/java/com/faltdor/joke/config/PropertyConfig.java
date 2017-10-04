package com.faltdor.joke.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Value("${datasource.url}")
	String url;
	
	@Value("${datasource.username}")
	String username;
	
	@Value("${datasource.password}")
	String password;
	
	@Value("${datasource.driverClassName}")
	String driverClassName;
	
	@Bean
	public FakeDataSource dataSource() {
		return new FakeDataSource(url,username,password,driverClassName);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	
}
