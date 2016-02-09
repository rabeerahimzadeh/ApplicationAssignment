package com.application.assignment.service;

import com.application.assignment.bean.EmployeeCompanyBean;
import com.application.assignment.dao.EmployeeCompanyDAO;
import com.application.assignment.model.CompanyEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeCompanyServiceImpl implements EmployeeCompanyService {


    @Autowired
    EmployeeCompanyDAO employeeCompanyDAO;

    @Transactional
    public CompanyEmployee findCompanyEmployee(Integer companyId, Integer employeeId) {
        return employeeCompanyDAO.findCompanyEmployee(companyId, employeeId);
    }

    public void deleteEmployeeCompany(Integer companyId, Integer employeeId) {
        employeeCompanyDAO.deleteEmployeeCompany(companyId, employeeId);
    }


    @Transactional
    public void updateEmployeeCompany(EmployeeCompanyBean employeeCompanyBean) {

        for (Integer employeeId : employeeCompanyBean.getSelection()) {
            CompanyEmployee companyEmployee = findCompanyEmployee(employeeCompanyBean.getCompanyId(), employeeId);
            //Check if the Employee of company is not exist add it to the company
            if (companyEmployee == null) {
                employeeCompanyDAO.updateEmployeeCompany(employeeCompanyBean.getCompanyId(), employeeId);
                // Otherwise if exist delete from company
            } else {
                employeeCompanyDAO.deleteEmployeeCompany(employeeCompanyBean.getCompanyId(), employeeId);
            }
        }


    }


}
