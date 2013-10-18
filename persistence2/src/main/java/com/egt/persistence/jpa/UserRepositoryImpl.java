package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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
	public MasUserRoleMappingEntity validateLogin(MasUserRoleMappingEntity masUserRoleMappingEntity) throws DatabaseException {
        MasUserRoleMappingEntity result = new MasUserRoleMappingEntity();
        List masUserEntityList = super.findByExample(masUserRoleMappingEntity.getMasUserEntity());
        List masUserRoleEntityList = super.findByExample(masUserRoleMappingEntity.getMasUserRoleEntity());
        MasUserEntity masUserEntity = new MasUserEntity();
        MasUserRoleEntity masUserRoleEntity = new MasUserRoleEntity();
        if(masUserEntityList != null && masUserEntityList.size() > 0){
            masUserEntity = (MasUserEntity)masUserEntityList.get(0);
        }

        if(masUserRoleEntityList != null && masUserEntityList.size() >0){
            masUserRoleEntity = (MasUserRoleEntity)masUserRoleEntityList.get(0);
        }
        masUserRoleMappingEntity.setMasUserEntity(masUserEntity);
        masUserRoleMappingEntity.setMasUserRoleEntity(masUserRoleEntity);

        List mappingList = super.findByExample(masUserRoleMappingEntity);
        if(mappingList != null && mappingList.size() > 0){
            result = (MasUserRoleMappingEntity)mappingList.get(0);
        }
		return result;
	}

    @Override
    public MasUserRoleMappingEntity findUserByUserName(String username) throws DatabaseException {
        MasUserEntity masUserEntity = new MasUserEntity();
        masUserEntity.setUsername(username);
        masUserEntity = (MasUserEntity)super.findSingleByExample(masUserEntity);


        return null;
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

    @Override
    public void saveUserRoleMapping(MasUserRoleMappingEntity masUserRoleMappingEntity) throws DatabaseException{
        super.save(masUserRoleMappingEntity);
    }


}
