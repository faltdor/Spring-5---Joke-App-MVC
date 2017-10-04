package com.faltdor.joke.bootstrap;

import static org.junit.Assert.assertNotNull;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.faltdor.joke.config.DefaultPropertyConfig;
import com.faltdor.joke.config.PropertyConfig;



@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private PropertyConfig propertyConfig;
	private DefaultPropertyConfig defaultpropertyConfig;
	

	public DevBootstrap(PropertyConfig propertyConfig,
						DefaultPropertyConfig defaultpropertyConfig) {
		this.propertyConfig = propertyConfig;
		this.defaultpropertyConfig = defaultpropertyConfig;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		checkPropertiesDatasourceFromCustomProperties();
		checkPropertiesDatasourceFromProfileProperties();
	}
	
	private void checkPropertiesDatasourceFromCustomProperties() {
		assertNotNull(this.propertyConfig.dataSource().getUsername());
		System.out.println("*********************************************");
		System.out.println(this.propertyConfig.dataSource().getUsername());
		System.out.println(this.propertyConfig.dataSource().getUrl());
	}
	
	private void checkPropertiesDatasourceFromProfileProperties() {
		assertNotNull(this.defaultpropertyConfig.dataSource());
		System.out.println("*********************************************");
		System.out.println(this.defaultpropertyConfig.dataSource().toString());
	}


}
