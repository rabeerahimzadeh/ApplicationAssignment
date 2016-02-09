package com.application.assignment.dao;

import com.application.assignment.model.CompanyOwner;


public interface OwnerCompanyDAO {
    public void updateOwnerCompany(Integer companyId, Integer ownerId);

    public CompanyOwner findCompanyOwner(Integer companyId, Integer ownerId);

    public void deleteOwnerCompany(Integer companyId, Integer employeeId);
}
