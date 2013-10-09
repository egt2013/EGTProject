package com.egt.persistence.services;

import com.egt.persistence.entity.MasUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.core.common.util.StringUtil;
import com.egt.persistence.jpa.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    
    public void createOrUpdateUser(MasUserEntity user) throws DatabaseException {
        if(user != null){
            if(user.getMasCustomerEntity() != null){
                if(user.getMasCustomerEntity().getMasLanguageEntityDefault() != null){
                    userRepo.saveLanguage(user.getMasCustomerEntity().getMasLanguageEntityDefault());
                }

                if(user.getMasCustomerEntity().getMasBusinessEntity() != null){
                    userRepo.saveBusiness(user.getMasCustomerEntity().getMasBusinessEntity());
                }

                userRepo.saveCustomer(user.getMasCustomerEntity());
            }

//            userRepo.saveUser(user);
        }

    }

	@Override
	public MasUserEntity validateLogin(MasUserEntity user) throws LoginInvalidException,DatabaseException {
		MasUserEntity result = userRepo.validateLogin(user);
		if(result == null || StringUtil.isEmpty(result.getUsername())){
			throw new LoginInvalidException();
		}
		return result;
	}
    
    
}
