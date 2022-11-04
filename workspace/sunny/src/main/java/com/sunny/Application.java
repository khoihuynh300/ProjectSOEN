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
}