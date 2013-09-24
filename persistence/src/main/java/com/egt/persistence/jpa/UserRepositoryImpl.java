package com.egt.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.util.StringUtil;
import com.egt.persistence.entity.UserBean;
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository{

	public String getCriteria(UserBean user){
		StringBuffer sql = new StringBuffer();
		if(!StringUtil.isEmpty(user.getUserName())){
			sql.append(" AND USERNAME = '"+user.getUserName()+"' \n");
		}
		if(!StringUtil.isEmpty(user.getPassword())){
			sql.append(" AND PASSWORD = '"+user.getPassword()+"' \n");
		}
		
		return sql.toString();
	}
	
	@Override
	public UserBean validateLogin(UserBean bean) throws DatabaseException {
		UserBean user = new UserBean();
		StringBuffer sql = new StringBuffer();
		String criteria = getCriteria(bean);
		sql.append(" SELECT DISTINCT USER_ID \n");
		sql.append("     , USERNAME \n");
		sql.append("     , PASSWORD \n");
		sql.append(" FROM USER \n");
		sql.append(" WHERE 1=1 ");
		sql.append(criteria);
		user = (UserBean)nativeQuery(sql.toString(), UserBean.class);
		return user;
	}


	@Override
	public void saveUser(UserBean user) throws DatabaseException {
		super.save(user);
		
	}

}
