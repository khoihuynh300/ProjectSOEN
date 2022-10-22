package com.sunny.dao.impl;

import com.sunny.dao.IImageDao;

public class ImageDaoImpl implements IImageDao {
//	@Override
//	public Image createImage(Image image) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Transaction t = session.beginTransaction();
//			session.save(image);
//			t.commit();
//			session.close();
//			return image;
//		}
//	}
//
//	@Override
//	public Image getImageById(int id) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Image result = session.get(Image.class, id);
//			session.close();
//			return result;
//		}
//	}
//
//	@Override
//	public void updateImage(Image image) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Transaction t = session.beginTransaction();
//			session.update(image);
//			t.commit();
//			session.close();
//		}
//	}
}
