package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.MasUserEntity;


public interface UserRepository {
    public MasUserEntity validateLogin(MasUserEntity user) throws DatabaseException;
    public void saveUser(MasUserEntity user) throws DatabaseException;
}
