package com.application.assignment.controller;


import com.application.assignment.bean.CompanyBean;
import com.application.assignment.model.Company;
import com.application.assignment.service.CompanyServive;
import com.application.assignment.service.EmployeeService;
import com.application.assignment.util.Convertor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CompanyController {


    private static final Logger logger = Logger.getLogger(CompanyController.class);

    @Autowired
    CompanyServive companyServive;

    @Autowired
    EmployeeService employeeService;

    /**
     * Get the list of company
     *
     * @return
     */

    @RequestMapping(value = "/company", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<CompanyBean> allCompany() {
        if (logger.isDebugEnabled())
            logger.debug("Enter CompanyController.allCompany ");
        return Convertor.companyModelToBean(companyServive.findAllCompanies());
    }


    /**
     * Get specified company
     *
     * @param id
     * @param response
     * @return
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    CompanyBean companyDetails(@PathVariable Integer id,
                               HttpServletResponse response) {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter CompanyController.companyDetails ");
            logger.debug("Company Id is: " + id);
        }
        Company company = companyServive.companyDetails(id);
        CompanyBean companyBean = Convertor.companyDetailsModelToBean(company);
        return companyBean;
    }

    /**
     * Update the specified company
     *
     * @param response
     * @param companyBean
     */


    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public
    @ResponseBody
    void updateCompanyDetail(HttpServletResponse response, @RequestBody CompanyBean companyBean) {
        if (logger.isDebugEnabled())
            logger.debug("Enter CompanyController.updateCompanyDetail ");

        try {
            companyServive.updateCompanyDetails(companyBean.getCompanyId(), companyBean.getName(), companyBean.getAddress(), companyBean.getCity(), companyBean.getCountry(), companyBean.getEmail(), companyBean.getPhoneNumber());
            if (logger.isDebugEnabled())
                logger.debug("Exit CompanyController.updateCompanyDetail");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            logger.error("Exception :" + e);
        }
    }

    /**
     * Add the company
     *
     * @param response
     * @param companyBean
     */

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public
    @ResponseBody
    void addCompany(HttpServletResponse response, @RequestBody CompanyBean companyBean) {
        if (logger.isDebugEnabled())
            logger.debug("Enter CompanyController.addCompany ");
        try {
            companyServive.addCompany(companyBean.getName(), companyBean.getAddress(), companyBean.getCity(), companyBean.getCountry(), companyBean.getEmail(), companyBean.getPhoneNumber());
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            logger.error("Exception :" + e);
        }
    }

}
