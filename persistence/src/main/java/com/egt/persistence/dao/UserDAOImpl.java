package com.egt.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.util.StringUtil;
import com.egt.persistence.entity.User;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO{

	public String getCriteria(User user){
		StringBuffer sql = new StringBuffer();
		if(!StringUtil.isEmpty(user.getUserName())){
			sql.append(" AND USERNAME = '"+user.getUserName()+"' \n");
		}
		if(!StringUtil.isEmpty(user.getPassword())){
			sql.append(" AND PASSWORD = '"+user.getPassword()+"' \n");
		}
		
		return sql.toString();
	}
	
	public User findUserItem(User bean)throws DatabaseException {
		User user = new User();
		StringBuffer sql = new StringBuffer();
		String criteria = getCriteria(bean);
		sql.append(" SELECT DISTINCT USER_ID ");
		sql.append("     , USERNAME ");
		sql.append("     , PASSWORD ");
		sql.append(" FROM USER ");
		
		sql.append(criteria);
		user = (User)nativeQuery(sql.toString(), User.class);
		return user;
	}

	public void save(User user) throws DatabaseException {
		super.save(user);
		
	}
	
	public boolean isUserExists(User user) throws DatabaseException{
		boolean isUserExists = false;
		StringBuffer sql = new StringBuffer();
		String criteria = getCriteria(user);
		sql.append(" SELECT USER_ID \n");
		sql.append(" FROM USER \n");
		sql.append(" WHERE 1=1 \n");
		sql.append(criteria);
		List<User> resultList = (ArrayList<User>)nativeQuery(sql.toString());
		if(resultList != null && resultList.size() > 0 ){
			isUserExists = true;
		}
		clear();
		return isUserExists;
	}

}
