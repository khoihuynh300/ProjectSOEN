package com.sunny.connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.sunny.pojo.Brand;
import com.sunny.pojo.Cart;
import com.sunny.pojo.Discount;
import com.sunny.pojo.Employee;
import com.sunny.pojo.Item;
import com.sunny.pojo.ItemAttribute;
import com.sunny.pojo.ItemType;
import com.sunny.pojo.User;

public class HibernateUtil {
	private final static SessionFactory Factory;

	static {
		Configuration conf = new Configuration();
		Properties pros = new Properties();
		pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		pros.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		pros.put(Environment.URL, "jdbc:mysql://localhost:3306/onlineshop");
		pros.put(Environment.USER, "root");
		pros.put(Environment.PASS, "123456789");

		conf.setProperties(pros);
		conf.addAnnotatedClass(User.class);
		conf.addAnnotatedClass(Cart.class);
		conf.addAnnotatedClass(Brand.class);
		conf.addAnnotatedClass(Discount.class);
		conf.addAnnotatedClass(Item.class);
		conf.addAnnotatedClass(ItemType.class);
		conf.addAnnotatedClass(ItemAttribute.class);
		conf.addAnnotatedClass(Employee.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

		Factory = conf.buildSessionFactory(registry);

	}

	public static SessionFactory getFactory() {
		return Factory;
	}
}
