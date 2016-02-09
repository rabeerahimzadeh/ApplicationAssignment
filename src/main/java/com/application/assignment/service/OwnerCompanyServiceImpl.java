package com.application.assignment.service;


import com.application.assignment.bean.OwnerCompanyBean;
import com.application.assignment.dao.OwnerCompanyDAO;
import com.application.assignment.model.CompanyOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerCompanyServiceImpl implements OwnerCompanyService {


    @Autowired
    OwnerCompanyDAO ownerCompanyDAO;

    @Transactional
    public CompanyOwner findCompanyOwner(Integer companyId, Integer employeeId) {
        return ownerCompanyDAO.findCompanyOwner(companyId, employeeId);
    }


    @Transactional
    public void updateOwnerCompany(OwnerCompanyBean ownerCompanyBean) {

        for (Integer employeeId : ownerCompanyBean.getSelection()) {
            CompanyOwner companyOwner = findCompanyOwner(ownerCompanyBean.getCompanyId(), employeeId);
            if (companyOwner == null) {
                ownerCompanyDAO.updateOwnerCompany(ownerCompanyBean.getCompanyId(), employeeId);
            } else {
                ownerCompanyDAO.deleteOwnerCompany(ownerCompanyBean.getCompanyId(), employeeId);
            }
        }


    }

}
