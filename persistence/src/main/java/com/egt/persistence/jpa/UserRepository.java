package com.egt.persistence.jpa;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.User;


public interface UserRepository {
    public User validateLogin(User user) throws DatabaseException;
    public void saveUser(User user) throws DatabaseException;
}
