package by.epam.apartment.DAO.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	private static final ThreadLocal<Session> threadSession = new ThreadLocal<>();
	private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<>();

	// FIXME: Обработка ошибок!
	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException ex) {
			// Log the exception.
			// FIXME: some special exception should be thrown
			throw ex;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		Session s = threadSession.get();
		// Open a new Session, if this thread has none yet
		try {
			if (s == null) {
				s = sessionFactory.openSession();
				threadSession.set(s);
			}
		} catch (HibernateException ex) {
			// TODO: throw an exception
		}
		return s;
	}

	public static void closeSession() {
		try {
			Session s = threadSession.get();
			threadSession.set(null);
			if (s != null && s.isOpen())
				s.close();
		} catch (HibernateException ex) {
			// TODO: throw an exception
		}
	}

	public static void beginTransaction() {
		Transaction tx = threadTransaction.get();
		try {
			if (tx == null) {
				tx = getSession().beginTransaction();
				threadTransaction.set(tx);
			}
		} catch (HibernateException ex) {
			// TODO: throw an exception
		}
	}

	public static void commitTransaction() {
		Transaction tx = threadTransaction.get();
		try {
			TransactionStatus txStatus = tx.getStatus();

			if (tx != null && txStatus.isNotOneOf(TransactionStatus.COMMITTED, TransactionStatus.ROLLED_BACK)) {
				tx.commit();
				threadTransaction.set(null);
			}
		} catch (HibernateException ex) {
			rollbackTransaction();
			// TODO: throw an exception
		}
	}

	public static void rollbackTransaction() {
		Transaction tx = threadTransaction.get();
		try {
			threadTransaction.set(null);
			TransactionStatus txStatus = tx.getStatus();

			if (tx != null && txStatus.isNotOneOf(TransactionStatus.COMMITTED, TransactionStatus.ROLLED_BACK)) {
				tx.rollback();
			}
		} catch (HibernateException ex) {
			// TODO: throw an exception
		} finally {
			closeSession();
		}
	}
}