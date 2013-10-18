package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.*;


public interface UserRepository {
    public MasUserRoleMappingEntity validateLogin(MasUserRoleMappingEntity masUserRoleMappingEntity) throws DatabaseException;
    public MasUserRoleMappingEntity findUserByUserName(String username) throws DatabaseException;
    public void saveUser(MasUserEntity user) throws DatabaseException;
    public void saveLanguage(MasLanguageEntity lang) throws DatabaseException;
    public void saveBusiness(MasBusinessEntity business) throws DatabaseException;
    public void saveCustomer(MasCustomerEntity customer) throws DatabaseException;
    public void saveUserRole(MasUserRoleEntity masUserRoleEntity) throws DatabaseException;
    public void saveUserRoleMapping(MasUserRoleMappingEntity masUserRoleMappingEntity) throws DatabaseException;
}
