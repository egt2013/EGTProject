package com.egt.persistence.services;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.egt.persistence.config.PersistenceJPAConfigXml;
import com.egt.persistence.dao.UserDAO;
import com.egt.persistence.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfigXml.class }, loader = AnnotationConfigContextLoader.class)
public class TestUserService {
    @Autowired
    private UserService service;
    @Autowired
    private UserDAO dao;
   
    @Test
    public final void whenInvalidEntityIsCreated_thenDataException() throws Exception {
    	User user = new User();
    	user.setUserName("test");
    	user.setPassword("password");
    	user.setCreatedBy("tip");
    	user.setModifiedBy("tip");
    	user.setCreateDate(new Date());
    	user.setModifiedDate(new Date());
    	service.createOrUpdateCostCentreCodes(user);
    }
}
