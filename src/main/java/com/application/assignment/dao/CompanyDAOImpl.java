package com.application.assignment.dao;

import com.application.assignment.model.Company;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CompanyDAOImpl implements CompanyDAO {


    private static final Logger logger = Logger.getLogger(CompanyDAOImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    /**
     * Fetch all companies from DB.
     *
     * @return the all companies
     */
    public List<Company> allCompanies() {
        if (logger.isDebugEnabled())
            logger.debug("Enter CompanyDAOImpl.allCompany ");
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Company.class);
        List list = criteria.list();
        session.getTransaction().commit();
        if (logger.isDebugEnabled())
            logger.debug("Exit CompanyDAOImpl.allCompany ");
        return list;
    }

    /**
     * Find the Company By CompanyId
     *
     * @param companyId
     * @return
     */
    public Company findCompanyByCompanyId(Integer companyId) {
        if (logger.isDebugEnabled())
            logger.debug("Enter CompanyDAOImpl.findCompanyByCompanyId ");
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Company.class);
        criteria.add(Restrictions.eq("companyId", companyId));
        List<Company> list = criteria.list();
        tx.commit();
        if (!list.isEmpty())
            return list.get(0);
        if (logger.isDebugEnabled())
            logger.debug("Exit CompanyDAOImpl.findCompanyByCompanyId ");
        return new Company();
    }

    /**
     * Update Company Detail
     *
     * @param companyId
     * @param name
     * @param address
     * @param city
     * @param country
     * @param email
     * @param phoneNumber
     * @throws Exception
     */

    public void updateCompanyDetail(Integer companyId, String name, String address, String city, String country, String email, String phoneNumber) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Enter CompanyDAOImpl.updateCompanyDetail ");
            logger.debug("Comapany Id: " + companyId);
            logger.debug("name Id: " + name);
            logger.debug("country Id: " + country);
            logger.debug("city Id: " + city);
            logger.debug("address Id: " + address);
            logger.debug("phoneNumber Id: " + phoneNumber);
            logger.debug("email Id: " + email);
        }
        Company company = findCompanyByCompanyId(companyId);
        if (company != null) {
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            company.setName(name);
            company.setCountry(country);
            company.setCity(city);
            company.setAddress(address);
            company.setPhoneNumber(phoneNumber);
            company.setEmail(email);
            session.saveOrUpdate(company);
            session.getTransaction().commit();
        }
        if (logger.isDebugEnabled())
            logger.debug("Exit CompanyDAOImpl.updateCompanyDetail ");
    }

    /**
     * Add Company
     *
     * @param name
     * @param address
     * @param city
     * @param country
     * @param email
     * @param phoneNumber
     * @throws Exception
     */
    public void addCompany(String name, String address, String city, String country, String email, String phoneNumber) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Enter CompanyDAOImpl.updateCompanyDetail ");
            logger.debug("name Id: " + name);
            logger.debug("address Id: " + address);
            logger.debug("country Id: " + country);
            logger.debug("city Id: " + city);
            logger.debug("address Id: " + address);
            logger.debug("phoneNumber Id: " + phoneNumber);
            logger.debug("email Id: " + email);
        }

        Company company = new Company();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        company.setName(name);
        company.setCountry(country);
        company.setCity(city);
        company.setAddress(address);
        company.setPhoneNumber(phoneNumber);
        company.setEmail(email);
        session.saveOrUpdate(company);
        session.getTransaction().commit();

        if (logger.isDebugEnabled())
            logger.debug("Exit CompanyDAOImpl.addCompany ");

    }
}
