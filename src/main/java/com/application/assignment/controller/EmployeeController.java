package com.application.assignment.controller;


import com.application.assignment.bean.EmployeeBean;
import com.application.assignment.bean.EmployeeCompanyBean;
import com.application.assignment.service.EmployeeCompanyService;
import com.application.assignment.service.EmployeeService;
import com.application.assignment.util.Convertor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeCompanyService employeeCompanyService;


    /**
     * Get the all Employees
     *
     * @param companyId
     * @return
     */

    @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<EmployeeBean> allEmployee(@RequestParam("companyId") Integer companyId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter EmployeeController.allEmployee ");
            logger.debug("Company Id:" + companyId);
        }
        List<EmployeeBean> employeeBeans = Convertor.employeeModelToBean(employeeService.findAllEmployees());
        List<EmployeeBean> employeeBeanListResult = new ArrayList<EmployeeBean>();
        for (EmployeeBean employeeBean : employeeBeans) {
            //check if the employee of company exist set checkbox true
            if (employeeCompanyService.findCompanyEmployee(companyId, employeeBean.getEmployeeId()) != null) {
                employeeBean.setSelected(true);
            } else {
                //else set checkbox false
                employeeBean.setSelected(false);
            }

            employeeBeanListResult.add(employeeBean);
            if (logger.isDebugEnabled())
                logger.debug("Exit EmployeeController.allEmployee ");
        }
        return employeeBeanListResult;
    }

    /**
     * Update the employee
     *
     * @param response
     * @param employeeCompanyBean
     */

    @RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    void updateEmployee(HttpServletResponse response, @RequestBody EmployeeCompanyBean employeeCompanyBean) {
        if (logger.isDebugEnabled())
            logger.debug("Enter EmployeeController.updateEmployee ");
        try {
            employeeCompanyService.updateEmployeeCompany(employeeCompanyBean);
            if (logger.isDebugEnabled())
                logger.debug("Exit EmployeeController.updateEmployee ");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            logger.error("Exception :" + e);
        }


    }
}
