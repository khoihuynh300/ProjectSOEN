package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IShipperDao;
import com.sunny.model.Shipper;

public class ShipperDaoImpl implements IShipperDao {
	@Override
	public Shipper createShipper(Shipper shipper) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(shipper);
			t.commit();
			session.close();
			return shipper;
		}
	}

	@Override
	public List<Shipper> getAllShipper() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Shipper> result = session.createQuery("FROM Shipper", Shipper.class).getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public void updateShipper(Shipper shipper) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.update(shipper);
			t.commit();
			session.close();
		}
	}

	@Override
	public void activateShipper(Shipper shipper) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Shipper temp = getShipperById(shipper.getShipperId());
			temp.setDeleted(false);
			session.save(shipper);
			t.commit();
			session.close();
		}
	}

	@Override
	public void deleteShipper(Shipper shipper) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Shipper temp = getShipperById(shipper.getShipperId());
			temp.setDeleted(true);
			session.save(shipper);
			t.commit();
			session.close();
		}
	}

	@Override
	public Shipper getShipperById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Shipper result = session.get(Shipper.class, id);
			session.close();
			return result;
		}
	}

	@Override
	public Shipper getShipperByUserId(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Shipper> result = session.createQuery("FROM Shipper WHERE UserId.UserId = :UserId", Shipper.class)
					.setParameter("UserId", userId).getResultList();
			if (result.size() == 0)
				return null;
			session.close();
			return result.get(0);
		}
	}
}
