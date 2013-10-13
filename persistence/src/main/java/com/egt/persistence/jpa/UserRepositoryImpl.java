package com.egt.persistence.jpa;

import com.egt.persistence.entity.User;
import org.springframework.stereotype.Repository;

import com.egt.core.common.exception.DatabaseException;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository{

	public String getCriteria(User user){
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
	public User validateLogin(User bean) throws DatabaseException {
		User user = new User();
		return user;
	}


	@Override
	public void saveUser(User user) throws DatabaseException {
		super.save(user);
		
	}

}
