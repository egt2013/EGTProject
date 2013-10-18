package com.egt.ws.security;

import com.egt.persistence.entity.MasUserRoleMappingEntity;
import com.egt.persistence.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MasUserRoleMappingEntity masUserRoleMappingEntity = userService.validateLogin();
        return null;
    }
}
