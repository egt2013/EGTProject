package com.egt.ws.security;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.persistence.entity.MasUserEntity;
import com.egt.persistence.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
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
    @SuppressWarnings("deprecation")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MasUserEntity sample = new MasUserEntity();
        sample.setUsername(username);

        UserDetails userDetails = null;
        try {
            sample = userService.validateLogin(sample);
            userDetails = new User(username, sample.getPassword(), true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl(sample.getMasUserRoleEntity().getUserRole())});
        } catch (LoginInvalidException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DatabaseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return userDetails;
    }
}
