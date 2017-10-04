package com.faltdor.joke.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class PropertyConfig {

	@Value("${datasource.url}")
	String url;
	
	@Value("${datasource.username}")
	String username;
	
	@Value("${datasource.password}")
	String password;
	
	@Value("${datasource.driverClassName}")
	String driverClassName;
	
	@Value("${jms.url}")
	String jmsUrl;
	
	@Value("${jms.username}")
	String jmsUsername;
	
	@Value("${jms.password}")
	String jmsPassword;
	
	@Bean
	public FakeDataSource dataSource() {
		return new FakeDataSource(url,username,password,driverClassName);
	}
	
	@Bean
	public JmsFakeDataSource jmsSource() {
		return new JmsFakeDataSource(jmsUrl,jmsUsername,jmsPassword);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	
}
