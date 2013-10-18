package com.egt.persistence.services;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.core.common.util.StringUtil;
import com.egt.persistence.entity.MasUserEntity;
import com.egt.persistence.entity.MasUserRoleEntity;
import com.egt.persistence.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    
    public void createOrUpdateUser(MasUserEntity user) throws DatabaseException {
        if(user != null && user.getMasUserRoleEntity() != null){
            if(user.getMasCustomerEntity() != null){
                if(user.getMasCustomerEntity().getMasLanguageEntityDefault() != null){
                    userRepo.saveLanguage(user.getMasCustomerEntity().getMasLanguageEntityDefault());
                }

                if(user.getMasCustomerEntity().getMasBusinessEntity() != null){
                    userRepo.saveBusiness(user.getMasCustomerEntity().getMasBusinessEntity());
                }

                userRepo.saveCustomer(user.getMasCustomerEntity());
            }

            userRepo.saveUserRole(user.getMasUserRoleEntity());

            userRepo.saveUser(user);
        }



    }

	@Override
	public MasUserEntity validateLogin(MasUserEntity masUserEntity) throws LoginInvalidException,DatabaseException {
        MasUserEntity result = userRepo.validateLogin(masUserEntity);
		if(result == null || StringUtil.isEmpty(result.getUsername())){
			throw new LoginInvalidException();
		}
		return result;
	}

}
