package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.UserBean;


public interface UserRepository {
    public UserBean validateLogin(UserBean user) throws DatabaseException;
    public void saveUser(UserBean user) throws DatabaseException;
}
