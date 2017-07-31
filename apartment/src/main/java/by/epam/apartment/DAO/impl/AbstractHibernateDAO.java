package by.epam.apartment.DAO.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import by.epam.apartment.DAO.GenericDAO;
import by.epam.apartment.DAO.util.HibernateUtil;

public class AbstractHibernateDAO<E> implements GenericDAO<E> {

	private final Class<E> clazz;

	public AbstractHibernateDAO(Class<E> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void add(E object) {
		try {
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			session.save(object);
			HibernateUtil.commitTransaction();

			/*
			 * } catch (HibernateException e) { HibernateUtil.rollbackTransaction();
			 * LOGGER.error(e.getMessage(), e); throw new DAOException(e.getMessage(), e); }
			 * catch (Exception e) { LOGGER.fatal(e.getMessage(), e); throw new
			 * DAOException(e.getMessage(), e);
			 */
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			// TODO: THROW AN EXCEPTION
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public E getById(Number id) {
		E result = null;
		try {
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			result = (E) session.load(clazz, id);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			// TODO: THROW AN EXCEPTION
		} finally {
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public List<E> getAll() {

		// TODO: check an opportunity to return null result
		List<E> resultList = null;
		try {
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			resultList = session.createCriteria(clazz).list();
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			// TODO: THROW AN EXCEPTION
		} finally {
			HibernateUtil.closeSession();
		}
		return resultList;
	}

	@Override
	public void update(E object) {
		try {
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			session.update(object);
			HibernateUtil.commitTransaction();

		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			// TODO: THROW AN EXCEPTION
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void delete(E object) {
		try {
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			session.delete(object);
			HibernateUtil.commitTransaction();
			session.flush();

		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			// TODO: THROW AN EXCEPTION
		} finally {
			HibernateUtil.closeSession();
		}
	}
}