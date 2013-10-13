package com.egt.persistence.services;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.persistence.entity.User;


public interface UserService {

    public void createOrUpdateUser(User user) throws DatabaseException;
    public User validateLogin(User user) throws LoginInvalidException,DatabaseException;
}
