package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.MasBusinessEntity;
import com.egt.persistence.entity.MasCustomerEntity;
import com.egt.persistence.entity.MasLanguageEntity;
import com.egt.persistence.entity.MasUserEntity;


public interface UserRepository {
    public MasUserEntity validateLogin(MasUserEntity user) throws DatabaseException;
    public void saveUser(MasUserEntity user) throws DatabaseException;
    public void saveLanguage(MasLanguageEntity lang) throws DatabaseException;
    public void saveBusiness(MasBusinessEntity business) throws DatabaseException;
    public void saveCustomer(MasCustomerEntity customer) throws DatabaseException;
}
