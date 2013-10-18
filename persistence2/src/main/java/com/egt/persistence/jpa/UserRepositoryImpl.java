package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository{
	
	@Override
	public MasUserEntity validateLogin(MasUserEntity masUserEntity) throws DatabaseException {
        MasUserEntity result = new MasUserEntity();
        List mappingList = super.findByExample(masUserEntity);
        if(mappingList != null && mappingList.size() > 0){
            result = (MasUserEntity)mappingList.get(0);
        }
		return result;
	}

    @Override
	public void saveUser(MasUserEntity user) throws DatabaseException {
		super.save(user);
		
	}

    @Override
    public void saveLanguage(MasLanguageEntity lang) throws DatabaseException {
        super.save(lang);
    }

    @Override
    public void saveBusiness(MasBusinessEntity business) throws DatabaseException {
        super.save(business);
    }

    @Override
    public void saveCustomer(MasCustomerEntity customer) throws DatabaseException {
        super.save(customer);
    }

    @Override
    public void saveUserRole(MasUserRoleEntity masUserRoleEntity) throws DatabaseException {
        super.save(masUserRoleEntity);
    }

}
