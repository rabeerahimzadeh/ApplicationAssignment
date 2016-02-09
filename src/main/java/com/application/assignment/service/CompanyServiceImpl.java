package com.application.assignment.service;

import com.application.assignment.dao.CompanyDAO;
import com.application.assignment.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyServive {


    @Autowired
    CompanyDAO companyDAO;


    @Transactional
    public List<Company> findAllCompanies() {
        return companyDAO.allCompanies();
    }


    @Transactional
    public Company companyDetails(Integer companyId) {
        return companyDAO.findCompanyByCompanyId(companyId);
    }


    @Transactional
    public void updateCompanyDetails(Integer companyId, String name, String address, String city, String country, String email, String phoneNumber) throws Exception {
        companyDAO.updateCompanyDetail(companyId, name, address, city, country, email, phoneNumber);

    }


    @Transactional
    public void addCompany(String name, String address, String city, String country, String email, String phoneNumber) throws Exception {
        companyDAO.addCompany(name, address, city, country, email, phoneNumber);

    }
}
