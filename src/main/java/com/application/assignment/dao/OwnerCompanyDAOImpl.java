package com.application.assignment.dao;


import com.application.assignment.model.CompanyOwner;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OwnerCompanyDAOImpl implements OwnerCompanyDAO {


    private static final Logger logger = Logger.getLogger(OwnerCompanyDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    /**
     * Update Owner Company
     *
     * @param companyId
     * @param ownerId
     */
    public void updateOwnerCompany(Integer companyId, Integer ownerId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Enter OwnerCompanyDAOImpl.updateOwnerCompany ");
            logger.debug("Company Id : " + companyId);
            logger.debug("owner Id : " + ownerId);
        }

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        CompanyOwner companyOwner = new CompanyOwner();
        companyOwner.setCompanyId(companyId);
        companyOwner.setOwnerId(ownerId);
        session.saveOrUpdate(companyOwner);
        session.getTransaction().commit();

    }

    /**
     * Find Company Owner
     *
     * @param companyId
     * @param ownerId
     * @return
     */

    public CompanyOwner findCompanyOwner(Integer companyId, Integer ownerId) {
        if (logger.isDebugEnabled())
            logger.debug("Enter OwnerCompanyDAOImpl.findCompanyOwner ");
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(CompanyOwner.class);
        criteria.add(Restrictions.eq("companyId", companyId));
        criteria.add(Restrictions.eq("ownerId", ownerId));
        List<CompanyOwner> list = criteria.list();
        if (logger.isDebugEnabled())
            logger.debug("Exit OwnerCompanyDAOImpl.findCompanyOwner ");
        tx.commit();
        if (!list.isEmpty())
            return list.get(0);
        return null;
    }

    public void deleteOwnerCompany(Integer companyId, Integer employeeId) {
        if (logger.isDebugEnabled())
            logger.debug("Enter OwnerCompanyDAOImpl.deleteOwnerCompany ");
        CompanyOwner companyOwner = findCompanyOwner(companyId, employeeId);
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(companyOwner);
        session.getTransaction().commit();

        if (logger.isDebugEnabled())
            logger.debug("Exit OwnerCompanyDAOImpl.deleteOwnerCompany ");

    }

}
