package com.application.assignment.controller;

import com.application.assignment.bean.OwnerBean;
import com.application.assignment.bean.OwnerCompanyBean;
import com.application.assignment.service.OwnerCompanyService;
import com.application.assignment.service.OwnerService;
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
public class OwnerController {

    private static final Logger logger = Logger.getLogger(OwnerController.class);

    @Autowired
    OwnerService ownerService;

    @Autowired
    OwnerCompanyService ownerCompanyService;


    /**
     * Get all Owner list
     *
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/owner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<OwnerBean> allOwner(@RequestParam("companyId") Integer companyId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter OwnerController.allOwner ");
            logger.debug("Company Id:" + companyId);
        }
        List<OwnerBean> ownerBeans = Convertor.ownerModelToBean(ownerService.findAllOwners());
        List<OwnerBean> ownerBeanListResult = new ArrayList<OwnerBean>();
        for (OwnerBean ownerBean : ownerBeans) {
            //Check if the owner of company exist set checkbox true
            if (ownerCompanyService.findCompanyOwner(companyId, ownerBean.getOwnerId()) != null) {
                ownerBean.setSelected(true);
            } else
                //else set checkbox false
                ownerBean.setSelected(false);

            ownerBeanListResult.add(ownerBean);
            if (logger.isDebugEnabled())
                logger.debug("Exit OwnerController.allOwner ");
        }
        return ownerBeanListResult;
    }

    /**
     * Update the specified owner
     *
     * @param response
     * @param ownerCompanyBean
     */

    @RequestMapping(value = "/owner", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    void updateOwner(HttpServletResponse response, @RequestBody OwnerCompanyBean ownerCompanyBean) {
        if (logger.isDebugEnabled())
            logger.debug("Enter OwnerController.updateOwner ");
        try {
            ownerCompanyService.updateOwnerCompany(ownerCompanyBean);
            if (logger.isDebugEnabled())
                logger.debug("Exit OwnerController.updateOwner ");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            logger.error("Exception " + e);
        }

    }
}
