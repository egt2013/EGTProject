package com.egt.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egt.persistence.entity.User;
import com.egt.persistence.jpa.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository dao;
    
    public void createOrUpdateCostCentreCodes(User user) throws Exception {
    	dao.save(user);
    }
}
