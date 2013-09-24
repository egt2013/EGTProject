package com.egt.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.core.common.util.StringUtil;
import com.egt.persistence.entity.UserBean;
import com.egt.persistence.jpa.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    
    public void createOrUpdateUser(UserBean user) throws DatabaseException {
    	userRepo.saveUser(user);
    }

	@Override
	public UserBean validateLogin(UserBean user) throws LoginInvalidException,DatabaseException {
		UserBean result = userRepo.validateLogin(user);
		if(result == null || StringUtil.isEmpty(result.getUserName())){
			throw new LoginInvalidException();
		}
		return result;
	}
    
    
}
