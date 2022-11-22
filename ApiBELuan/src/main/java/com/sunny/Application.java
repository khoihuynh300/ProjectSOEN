package com.sunny;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunny.connections.HibernateUtil;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.close();
		}
	}
	
	/*
	 https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://
	 localhost:8080/login-google&response_type=code
	 &client_id=271434263642-9mqvtbrcvv51mnf88rfdmedmpva3f5sq.apps.
	 googleusercontent.com&approval_prompt=force
	*/
}