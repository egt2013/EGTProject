package com.egt.persistence.services;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.core.common.util.StringUtil;
import com.egt.persistence.entity.MasUserEntity;
import com.egt.persistence.entity.MasUserRoleEntity;
import com.egt.persistence.entity.MasUserRoleMappingEntity;
import com.egt.persistence.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    
    public void createOrUpdateUser(MasUserEntity user,MasUserRoleEntity userRoleEntity) throws DatabaseException {
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

            userRepo.saveUser(user);
        }

        if(userRoleEntity != null){
            userRepo.saveUserRole(userRoleEntity);
        }

        MasUserRoleMappingEntity roleMapping = new MasUserRoleMappingEntity();
        roleMapping.setMasUserEntity(user);
        roleMapping.setMasUserRoleEntity(userRoleEntity);
        roleMapping.setCreatedBy("tipcc");
        roleMapping.setModifiedBy("tipcc");
        roleMapping.setStatus("A");
        roleMapping.setCreateDate(new Date());
        roleMapping.setModifiedDate(new Date());
        userRepo.saveUserRoleMapping(roleMapping);

    }

	@Override
	public MasUserRoleMappingEntity validateLogin(MasUserRoleMappingEntity masUserRoleMappingEntity) throws LoginInvalidException,DatabaseException {
        MasUserRoleMappingEntity result = userRepo.validateLogin(masUserRoleMappingEntity);
		if(result == null || StringUtil.isEmpty(result.getMasUserEntity().getUsername())){
			throw new LoginInvalidException();
		}
		return result;
	}

}
