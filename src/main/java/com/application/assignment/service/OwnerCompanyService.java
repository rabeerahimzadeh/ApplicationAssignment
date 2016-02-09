package com.application.assignment.service;

import com.application.assignment.bean.OwnerCompanyBean;
import com.application.assignment.model.CompanyOwner;


public interface OwnerCompanyService {
    public CompanyOwner findCompanyOwner(Integer companyId, Integer employeeId);

    public void updateOwnerCompany(OwnerCompanyBean ownerCompanyBean);
}
