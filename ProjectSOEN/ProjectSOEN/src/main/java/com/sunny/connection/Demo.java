package com.sunny.connection;

import org.hibernate.Session;

public class Demo {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getFactory().openSession();) {

			session.getTransaction().begin();// giao tác để thực hiện thêm xóa sửa có thể lưu xuống csdl

//			User user = session.get(User.class, 100);
//			Cart cart = new Cart();
//			cart.setUser(user);

//			User user = new User();
//			user.setAccountName("theluan");
//			user.setPassword("123456");
//			user.setRole(0);
//
//			session.save(user);
//			session.getTransaction().commit();

		}
	}
}
