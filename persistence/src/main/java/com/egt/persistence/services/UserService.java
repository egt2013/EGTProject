package com.egt.persistence.services;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.persistence.entity.UserBean;


public interface UserService {

    public void createOrUpdateUser(UserBean user) throws DatabaseException;
    public UserBean validateLogin(UserBean user) throws LoginInvalidException,DatabaseException;
}
