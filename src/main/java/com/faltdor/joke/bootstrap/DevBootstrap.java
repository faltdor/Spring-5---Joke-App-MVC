package com.faltdor.joke.bootstrap;

import static org.junit.Assert.assertNotNull;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.faltdor.joke.config.PropertyConfig;



@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private PropertyConfig propertyConfig;
	

	public DevBootstrap(PropertyConfig propertyConfig) {
		this.propertyConfig = propertyConfig;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		checkPropertiesDatasource();
	}
	
	private void checkPropertiesDatasource() {
		assertNotNull(this.propertyConfig.dataSource().getUsername());
		System.out.println("*********************************************");
		System.out.println(this.propertyConfig.dataSource().getUsername());
		System.out.println(this.propertyConfig.dataSource().getUrl());
	}


}
