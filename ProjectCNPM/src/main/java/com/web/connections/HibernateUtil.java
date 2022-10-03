package com.web.connections;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.web.model.Cart;
import com.web.model.CartItem;
import com.web.model.Customer;
import com.web.model.Discount;
import com.web.model.Employee;
import com.web.model.Invoice;
import com.web.model.InvoiceItem;
import com.web.model.OrderDetail;
import com.web.model.Orders;
import com.web.model.PaymentMethod;
import com.web.model.Product;
import com.web.model.ProductAttribute;
import com.web.model.ProductToAttribute;
import com.web.model.ProductType;
import com.web.model.User;

public class HibernateUtil {
	private final static SessionFactory Factory;

	static {
		Configuration conf = new Configuration();
		Properties pros = new Properties();
		pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		pros.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		pros.put(Environment.URL, "jdbc:mysql://localhost:3306/projectsoen");
		pros.put(Environment.USER, "root");
		pros.put(Environment.PASS, "123456789");

		conf.setProperties(pros);
		conf.addAnnotatedClass(User.class);
		conf.addAnnotatedClass(Customer.class);
		conf.addAnnotatedClass(Cart.class);
		conf.addAnnotatedClass(CartItem.class);
		conf.addAnnotatedClass(Discount.class);
		conf.addAnnotatedClass(Item.class);
		conf.addAnnotatedClass(ProductType.class);
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(ProductAttribute.class);
		conf.addAnnotatedClass(ProductToAttribute.class);
		conf.addAnnotatedClass(Employee.class);
		conf.addAnnotatedClass(PaymentMethod.class);
		conf.addAnnotatedClass(Orders.class);
		conf.addAnnotatedClass(OrderDetail.class);
		conf.addAnnotatedClass(Invoice.class);
		conf.addAnnotatedClass(InvoiceItem.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

		Factory = conf.buildSessionFactory(registry);

	}

	public static SessionFactory getFactory() {
		return Factory;
	}
}

//public class HibernateUtil {
//
//	private static final SessionFactory sessionFactory = buildSessionFactory();
//
//	private HibernateUtil() {
//		super();
//	}
//
//	private static SessionFactory buildSessionFactory() {
////		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
////				.configure("hibernate.cfg.xml") // Load hibernate.cfg.xml from resource folder by default
////				.build();
//		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
//				.build();
//		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//		return metadata.getSessionFactoryBuilder().build();
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public static void close() {
//		getSessionFactory().close();
//	}
//}
