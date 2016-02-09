package com.application.assignment.util;

import com.application.assignment.bean.CompanyBean;
import com.application.assignment.bean.EmployeeBean;
import com.application.assignment.bean.OwnerBean;
import com.application.assignment.model.Company;
import com.application.assignment.model.Employee;
import com.application.assignment.model.Owner;

import java.util.ArrayList;
import java.util.List;


public class Convertor {

    public static List<CompanyBean> companyModelToBean(List<Company> companyList) {
        List<CompanyBean> companyBeanList = new ArrayList<CompanyBean>();
        for (Company company : companyList) {
            CompanyBean companyBean = new CompanyBean();
            companyBean.setCompanyId(company.getCompanyId());
            companyBean.setAddress(company.getAddress());
            companyBean.setCity(company.getCity());
            companyBean.setCountry(company.getCountry());
            companyBean.setEmail(company.getEmail());
            companyBean.setName(company.getName());
            companyBean.setPhoneNumber(company.getPhoneNumber());
            companyBeanList.add(companyBean);
        }
        return companyBeanList;
    }


    public static CompanyBean companyDetailsModelToBean(Company company) {
        CompanyBean companyBean = new CompanyBean();
        companyBean.setCompanyId(company.getCompanyId());
        companyBean.setPhoneNumber(company.getPhoneNumber());
        companyBean.setName(company.getName());
        companyBean.setEmail(company.getEmail());
        companyBean.setAddress(company.getAddress());
        companyBean.setCity(company.getCity());
        companyBean.setCountry(company.getCountry());
        return companyBean;
    }

    public static List<EmployeeBean> employeeModelToBean(List<Employee> employeeList) {
        List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();
        for (Employee employee : employeeList) {
            EmployeeBean employeeBean = new EmployeeBean();
            employeeBean.setEmployeeId(employee.getEmployeeId());
            employeeBean.setFirstName(employee.getFirstName());
            employeeBean.setLastName(employee.getLastName());
            employeeBeanList.add(employeeBean);
        }
        return employeeBeanList;
    }


    public static List<OwnerBean> ownerModelToBean(List<Owner> ownerList) {
        List<OwnerBean> ownerBeanList = new ArrayList<OwnerBean>();
        for (Owner owner : ownerList) {
            OwnerBean ownerBean = new OwnerBean();
            ownerBean.setOwnerId(owner.getOwnerId());
            ownerBean.setFirstName(owner.getFirstName());
            ownerBean.setLastName(owner.getLastName());
            ownerBeanList.add(ownerBean);
        }
        return ownerBeanList;
    }

}