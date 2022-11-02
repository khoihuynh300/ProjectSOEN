package com.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sunny.dao.IUserDao;
import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.filter.AuthorizationFilter;
import com.sunny.model.User;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}
	
	/*
	 https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://
	 localhost:8080/login-google&response_type=code
	 &client_id=271434263642-9mqvtbrcvv51mnf88rfdmedmpva3f5sq.apps.
	 googleusercontent.com&approval_prompt=force
	*/
}