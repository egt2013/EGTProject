package com.egt.persistence.jpa;

import com.egt.persistence.entity.MasUserEntity;
import org.springframework.stereotype.Repository;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.util.StringUtil;

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

}
