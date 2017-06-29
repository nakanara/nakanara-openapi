package com.nakanara.openapi.servlet;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

/**
 * 오류:
 * Write operations are not allowed in read-only mode (FlushMode.MANUAL): Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker from transaction definition.
 at org.springframework.orm.hibernate4.HibernateTemplate.checkWriteOperationAllowed(HibernateTemplate.java:1135)
 *
 * 내용 :
 * https://stackoverflow.com/questions/25620303/how-can-i-globally-set-flushmode-for-hibernate-4-3-5-final-with-spring-4-0-6
 * Created by nakanara on 2017-06-29.
 */
public class AutoFlushOpenSessionInViewFilter extends OpenSessionInViewFilter {
    @Override
    protected Session openSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
        try {
            Session session = sessionFactory.openSession();
            session.setFlushMode(FlushMode.AUTO); // This line changes the default behavior
            return session;
        } catch (HibernateException ex) {
            throw new DataAccessResourceFailureException("Could not open Hibernate Session", ex);
        }
    }
}
