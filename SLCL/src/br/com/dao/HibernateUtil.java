package br.com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
	try {
	    sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	} catch (Throwable ex) {
	    System.err.println("Initial SessionFactory creation failed." + ex);
	    throw new ExceptionInInitializerError(ex);
	}
    }

    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public static <T> List<T> executeHql(String hql) {
	return returnQuery(hql).list();
    }

    public static <T> List<T> executeHql(Query query) {
	return query.list();
    }

    public static Query returnQuery(String hql) {
	Session session = getSessionFactory().openSession();
	return session.createQuery(hql);
    }

    static Session getSession() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}