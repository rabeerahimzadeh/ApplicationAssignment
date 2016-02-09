package com.application.assignment.service;

import com.application.assignment.bean.EmployeeCompanyBean;
import com.application.assignment.model.CompanyEmployee;


public interface EmployeeCompanyService {

    public void updateEmployeeCompany(EmployeeCompanyBean employeeCompanyBean);

    public CompanyEmployee findCompanyEmployee(Integer companyId, Integer employeeId);

    public void deleteEmployeeCompany(Integer companyId, Integer employeeId);

}
