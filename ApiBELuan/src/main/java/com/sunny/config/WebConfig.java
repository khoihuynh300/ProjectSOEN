package com.sunny.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sunny.filter.AuthorizationFilter;

@Configuration
public class WebConfig {
	@Bean
	FilterRegistrationBean authorizationFilterFilterRegistrationBean() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(new AuthorizationFilter());
		registrationBean.addUrlPatterns("/admin/*", "/shipper/*");
		registrationBean.setOrder(1);

		return registrationBean;
	}
}
