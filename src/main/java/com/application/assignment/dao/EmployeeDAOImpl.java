package com.application.assignment.dao;

import com.application.assignment.model.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {


    private static final Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    /**
     * Fetch all Employees
     *
     * @return
     */
    public List<Employee> allEmployees() {
        if (logger.isDebugEnabled())
            logger.debug("Enter EmployeeDAOImpl.allEmployees ");
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        List list = criteria.list();
        session.getTransaction().commit();
        if (logger.isDebugEnabled())
            logger.debug("Exit EmployeeDAOImpl.allEmployees ");
        return list;
    }

}
