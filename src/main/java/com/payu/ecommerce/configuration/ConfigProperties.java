package com.payu.ecommerce.configuration;

import com.payu.ecommerce.pojo.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigProperties {
	@Autowired
	Environment env;

	@Bean
	public Utils util() {

		return new Utils(env.getProperty("util.txValue"),env.getProperty("util.currency"),env.getProperty("util.orderNumber"),
						 env.getProperty("util.descriptionOrder"),env.getProperty("util.language"),env.getProperty("util.payerNumber"),
						 env.getProperty("util.contactNUmber"),env.getProperty("util.dniNumber"),env.getProperty("util.merchantApiLogin"),
						 env.getProperty("util.merchantApiKey"),env.getProperty("util.type"),env.getProperty("util.paymentMethod"),
						 env.getProperty("util.command"),env.getProperty("util.referenceCode"),env.getProperty("util.expirationDate"),
						 env.getProperty("util.uri"));
	}

	@Bean
	public Utils util2() {

		return new Utils(env.getProperty("util.txValue"),env.getProperty("util.currency"),env.getProperty("util.orderNumber"),
						 env.getProperty("util.descriptionOrder"),env.getProperty("util.language"),env.getProperty("util.payerNumber"),
						 env.getProperty("util.contactNUmber"),env.getProperty("util.dniNumber"),env.getProperty("util.merchantApiLogin"),
						 env.getProperty("util.merchantApiKey"),env.getProperty("util.type"),env.getProperty("util.paymentMethod"),
						 env.getProperty("util.command"),env.getProperty("util.referenceCode"),env.getProperty("util.expirationDate"),
						 env.getProperty("util.uri"));
	}


}
