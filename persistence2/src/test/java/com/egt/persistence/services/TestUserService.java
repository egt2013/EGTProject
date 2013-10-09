package com.egt.persistence.services;


import java.util.Date;

import com.egt.persistence.entity.MasBusinessEntity;
import com.egt.persistence.entity.MasCustomerEntity;
import com.egt.persistence.entity.MasLanguageEntity;
import com.egt.persistence.entity.MasUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.egt.persistence.config.PersistenceJPAConfigXml;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfigXml.class }, loader = AnnotationConfigContextLoader.class)
public class TestUserService {
    @Autowired
    private UserService service;
   
    @Test
    public final void crateOrUpdateUser() throws Exception {
        MasBusinessEntity business = new MasBusinessEntity();
        business.setBusiness("0001");
        business.setBusinessText("taxi");

        MasLanguageEntity lang = new MasLanguageEntity();
        lang.setLanguageCode("en");
        lang.setLanguageText("English");
        lang.setLocal("EN");

        MasCustomerEntity customer = new MasCustomerEntity();
        customer.setCustomer("test");
        customer.setMapZoomDefault(10);
        customer.setMasBusinessEntity(business);
        customer.setMasLanguageEntityDefault(lang);

    	MasUserEntity user = new MasUserEntity();
    	user.setUsername("test");
    	user.setPassword("passworccd");
    	user.setCreatedBy("tipcc");
    	user.setModifiedBy("tipcc");
        user.setStatus("A");
    	user.setCreateDate(new Date());
    	user.setModifiedDate(new Date());


        user.setMasCustomerEntity(customer);
    	service.createOrUpdateUser(user);
    }
/*    
    @Test
    public final void validateUser() throws Exception {
    	User user = new User();
    	user.setUserName("testcc");
    	user.setPassword("passworccd");
    	service.validateLogin(user);
    }*/
}
