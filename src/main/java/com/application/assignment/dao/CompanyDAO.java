package com.application.assignment.dao;

import com.application.assignment.model.Company;

import java.util.List;


public interface CompanyDAO {

    public List<Company> allCompanies();

    public Company findCompanyByCompanyId(Integer companyId);

    public void updateCompanyDetail(Integer companyId, String name, String address, String city, String country, String email, String phoneNumber) throws Exception;

    public void addCompany(String name, String address, String city, String country, String email, String phoneNumber) throws Exception;
}
