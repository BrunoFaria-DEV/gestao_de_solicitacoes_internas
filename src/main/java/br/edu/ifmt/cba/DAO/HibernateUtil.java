package br.edu.ifmt.cba.DAO;

import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class HibernateUtil {
	//atributo estático e imutável da fábrica de sessões
	private static final SessionFactory sessionFactory;

	//bloco estático
	static {
		try {
			sessionFactory = new Configuration().configure("/repository/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
