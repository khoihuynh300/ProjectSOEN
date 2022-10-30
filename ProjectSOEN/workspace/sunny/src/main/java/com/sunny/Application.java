package com.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sunny.filter.AuthorizationFilter;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	FilterRegistrationBean authorizationFilterFilterRegistrationBean() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(new AuthorizationFilter());
		registrationBean.addUrlPatterns("/admin/*");
		registrationBean.setOrder(2);

		return registrationBean;
	}
	/*
	 * https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://
	 * localhost:8080/login-google&response_type=code
	 * &client_id=271434263642-9mqvtbrcvv51mnf88rfdmedmpva3f5sq.apps.
	 * googleusercontent.com&approval_prompt=force
	 */
}