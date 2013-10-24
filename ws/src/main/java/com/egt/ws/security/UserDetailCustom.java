package com.egt.ws.security;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.persistence.entity.*;
import com.egt.persistence.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 18/10/2556
 * Time: 15:12 น.
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailCustom implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    @SuppressWarnings("deprecation")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            this.crateOrUpdateUser();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        MasUserEntity sample = new MasUserEntity();
        sample.setUsername(username);



        UserDetails userDetails = null;
        try {
            MasUserEntity bean = new MasUserEntity();
            bean = userService.validateLogin(sample);
            GrantedAuthority authen = new GrantedAuthorityImpl(bean.getMasUserRoleEntity().getUserRole());
            Set<GrantedAuthority> authenSet =  new HashSet<GrantedAuthority>();
            authenSet.add(authen);

            userDetails = new User(username, bean.getPassword(), true, true, true, true, authenSet);
        } catch (LoginInvalidException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DatabaseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return userDetails;
    }

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
        user.setUsername("tip");
        user.setPassword("password");
        user.setCreatedBy("tipcc");
        user.setModifiedBy("tipcc");
        user.setEnable(true);
        user.setStatus("A");
        user.setCreateDate(new Date());
        user.setModifiedDate(new Date());


        user.setMasCustomerEntity(customer);

        MasUserRoleEntity userRole = new MasUserRoleEntity();
        userRole.setUserRole("ROLE_USER");
        userRole.setCreatedBy("tipcc");
        userRole.setModifiedBy("tipcc");
        userRole.setStatus("A");
        userRole.setCreateDate(new Date());
        userRole.setModifiedDate(new Date());

        user.setMasUserRoleEntity(userRole);
        userService.createOrUpdateUser(user);
    }
}
