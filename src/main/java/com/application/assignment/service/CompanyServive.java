package com.application.assignment.service;

import com.application.assignment.model.Company;

import java.util.List;


public interface CompanyServive {

    public List<Company> findAllCompanies();

    public Company companyDetails(Integer companyId);

    public void updateCompanyDetails(Integer companyId, String name, String address, String city, String country, String email, String phoneNumber) throws Exception;

    public void addCompany(String name, String address, String city, String country, String email, String phoneNumber) throws Exception;
}
