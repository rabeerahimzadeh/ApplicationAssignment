package com.application.assignment.service;

import com.application.assignment.dao.OwnerDAO;
import com.application.assignment.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OwnerServiceImpl implements OwnerService {


    @Autowired
    OwnerDAO ownerDAO;


    @Transactional
    public List<Owner> findAllOwners() {
        return ownerDAO.allOwners();
    }


}
