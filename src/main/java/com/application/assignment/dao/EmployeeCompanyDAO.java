package com.application.assignment.dao;

import com.application.assignment.model.CompanyEmployee;


public interface EmployeeCompanyDAO {

    public void updateEmployeeCompany(Integer companyId, Integer employeeId);

    public CompanyEmployee findCompanyEmployee(Integer companyId, Integer employeeId);

    public void deleteEmployeeCompany(Integer companyId, Integer employeeId);
}
