package com.payu.ecommerce.configuration;

import com.payu.ecommerce.pojo.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ConfigProperties {
	@Bean
	@ConfigurationProperties(prefix = "util")
	public Utils util() {
		return new Utils();
	}

	@Bean
	@ConfigurationProperties(prefix = "util")
	public Utils util2() {
		return new Utils();
	}


}
