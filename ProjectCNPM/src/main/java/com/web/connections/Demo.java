package com.web.connections;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.model.User;

public class Demo {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getFactory().openSession()) {

			Transaction t = null;
			t = session.beginTransaction();// giao tác để thực hiện thêm xóa sửa có thể lưu xuống csdl

//			User user = session.get(User.class, 100);
//			Cart cart = new Cart();
//			cart.setUserId(user);

			User user = new User();
			user.setAccountName("luanlt");
			user.setPassword("123456");
			user.setRole(0);
			session.persist(user);
//
			t.commit();
			session.close();
			System.out.println("success!");
		}
	}
}
