package com.application.assignment.service;

import com.application.assignment.dao.EmployeeCompanyDAO;
import com.application.assignment.dao.EmployeeDAO;
import com.application.assignment.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeDAO employeeDAO;


    @Transactional
    public List<Employee> findAllEmployees() {

        return employeeDAO.allEmployees();

    }

}
