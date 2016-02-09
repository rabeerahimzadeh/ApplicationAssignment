package com.application.assignment.dao;

import com.application.assignment.model.CompanyEmployee;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class EmployeeCompanyDAOImpl implements EmployeeCompanyDAO {

    private static final Logger logger = Logger.getLogger(EmployeeCompanyDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    /**
     * Update Employee Company in DB
     *
     * @param companyId
     * @param employeeId
     */
    public void updateEmployeeCompany(Integer companyId, Integer employeeId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter EmployeeCompanyDAOImpl.updateEmployeeCompany ");
            logger.debug("Company Id: " + companyId);
            logger.debug("Employee Id: " + employeeId);
        }
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.setCompanyId(companyId);
        companyEmployee.setEmployeeId(employeeId);
        session.saveOrUpdate(companyEmployee);
        session.getTransaction().commit();

        if (logger.isDebugEnabled())
            logger.debug("Exit EmployeeCompanyDAOImpl.updateEmployeeCompany ");

    }

    /**
     * Find the employee of specefied company
     *
     * @param companyId
     * @param employeeId
     * @return
     */

    public CompanyEmployee findCompanyEmployee(Integer companyId, Integer employeeId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter EmployeeCompanyDAOImpl.findCompanyEmployee ");
            logger.debug("Company Id: " + companyId);
            logger.debug("Employee Id: " + employeeId);
        }
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(CompanyEmployee.class);
        criteria.add(Restrictions.eq("companyId", companyId));
        criteria.add(Restrictions.eq("employeeId", employeeId));
        List<CompanyEmployee> list = criteria.list();
        tx.commit();
        if (logger.isDebugEnabled())
            logger.debug("Exit EmployeeCompanyDAOImpl.findCompanyEmployee ");
        if (!list.isEmpty())
            return list.get(0);
        return null;
    }

    /**
     * Delete the Employee of specified Company
     *
     * @param companyId
     * @param employeeId
     */

    public void deleteEmployeeCompany(Integer companyId, Integer employeeId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter EmployeeCompanyDAOImpl.deleteEmployeeCompany ");
            logger.debug("Company Id: " + companyId);
            logger.debug("Employee Id: " + employeeId);
        }
        CompanyEmployee companyEmployee = findCompanyEmployee(companyId, employeeId);
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(companyEmployee);
        session.getTransaction().commit();
        if (logger.isDebugEnabled())
            logger.debug("Exit EmployeeCompanyDAOImpl.deleteEmployeeCompany ");

    }

}
