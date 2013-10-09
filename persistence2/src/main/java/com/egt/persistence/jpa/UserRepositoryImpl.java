package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.MasBusinessEntity;
import com.egt.persistence.entity.MasCustomerEntity;
import com.egt.persistence.entity.MasLanguageEntity;
import com.egt.persistence.entity.MasUserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository{

	public String getCriteria(MasUserEntity user){
		StringBuffer sql = new StringBuffer();
//		if(!StringUtil.isEmpty(user.getUserName())){
//			sql.append(" AND USERNAME = '"+user.getUserName()+"' \n");
//		}
//		if(!StringUtil.isEmpty(user.getPassword())){
//			sql.append(" AND PASSWORD = '"+user.getPassword()+"' \n");
//		}
//
		return sql.toString();
	}
	
	@Override
	public MasUserEntity validateLogin(MasUserEntity bean) throws DatabaseException {
		MasUserEntity user = new MasUserEntity();
		return user;
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


}
