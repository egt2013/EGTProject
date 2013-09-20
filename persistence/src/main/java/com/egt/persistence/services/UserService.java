package com.egt.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egt.persistence.dao.UserDAO;
import com.egt.persistence.entity.User;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO dao;
    
    public void createOrUpdateCostCentreCodes(User user) throws Exception {
    	dao.save(user);
    }
}
