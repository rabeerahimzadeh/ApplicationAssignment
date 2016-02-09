package com.application.assignment.dao;

import com.application.assignment.model.Owner;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class OwnerDAOImpl implements OwnerDAO {


    private static final Logger logger = Logger.getLogger(OwnerDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    /**
     * All Owners
     *
     * @return
     */
    public List<Owner> allOwners() {

        if (logger.isDebugEnabled())
            logger.debug("Enter OwnerDAOImpl.allOwners ");

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Owner.class);
        List list = criteria.list();
        session.getTransaction().commit();
        if (logger.isDebugEnabled())
            logger.debug("Exit OwnerDAOImpl.allOwners ");
        return list;
    }
}
