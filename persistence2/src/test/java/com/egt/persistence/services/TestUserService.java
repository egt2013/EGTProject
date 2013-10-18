package com.egt.persistence.services;


import com.egt.persistence.config.PersistenceJPAConfigXml;
import com.egt.persistence.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfigXml.class }, loader = AnnotationConfigContextLoader.class)
public class TestUserService {
    @Autowired
    private UserService userService;
   
    @Test
    public final void crateOrUpdateUser() throws Exception {
        MasBusinessEntity business = new MasBusinessEntity();
        business.setBusiness("0001");
        business.setBusinessText("taxi");
        business.setCreatedBy("tipcc");
        business.setModifiedBy("tipcc");
        business.setStatus("A");
        business.setCreateDate(new Date());
        business.setModifiedDate(new Date());

        MasLanguageEntity lang = new MasLanguageEntity();
        lang.setLanguageCode("en");
        lang.setLanguageText("English");
        lang.setLocal("EN");
        lang.setCreatedBy("tipcc");
        lang.setModifiedBy("tipcc");
        lang.setStatus("A");
        lang.setCreateDate(new Date());
        lang.setModifiedDate(new Date());

        MasCustomerEntity customer = new MasCustomerEntity();
        customer.setCustomer("test");
        customer.setMapZoomDefault(10);
        customer.setMasBusinessEntity(business);
        customer.setMasLanguageEntityDefault(lang);
        customer.setCreatedBy("tipcc");
        customer.setModifiedBy("tipcc");
        customer.setStatus("A");
        customer.setCreateDate(new Date());
        customer.setModifiedDate(new Date());

    	MasUserEntity user = new MasUserEntity();
    	user.setUsername("test");
    	user.setPassword("passworccd");
    	user.setCreatedBy("tipcc");
    	user.setModifiedBy("tipcc");
        user.setEnable(true);
        user.setStatus("A");
    	user.setCreateDate(new Date());
    	user.setModifiedDate(new Date());


        user.setMasCustomerEntity(customer);

        MasUserRoleEntity  userRole = new MasUserRoleEntity();
        userRole.setUserRole("ROLE_USER");
        userRole.setCreatedBy("tipcc");
        userRole.setModifiedBy("tipcc");
        userRole.setStatus("A");
        userRole.setCreateDate(new Date());
        userRole.setModifiedDate(new Date());
    	userService.createOrUpdateUser(user,userRole);
    }
    @Test
    public final void validateUser() throws Exception {
    	MasUserEntity user = new MasUserEntity();
    	user.setUsername("test");
    	user.setPassword("passworccd");

        MasUserRoleEntity masUserRoleEntity = new MasUserRoleEntity();
        masUserRoleEntity.setUserRole("ROLE_USER");

        MasUserRoleMappingEntity masUserRoleMappingEntity = new MasUserRoleMappingEntity();
        masUserRoleMappingEntity.setMasUserEntity(user);
        masUserRoleMappingEntity.setMasUserRoleEntity(masUserRoleEntity);


        masUserRoleMappingEntity = userService.validateLogin(masUserRoleMappingEntity);
        System.out.println(masUserRoleMappingEntity.getMasUserEntity().toString());
    }
}
