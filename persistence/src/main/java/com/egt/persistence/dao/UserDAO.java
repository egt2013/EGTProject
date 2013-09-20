package com.egt.persistence.dao;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.User;

public interface UserDAO {
    public void save(User user) throws DatabaseException;
    public User findUserItem(User user) throws DatabaseException;
    public boolean isUserExists(User user) throws DatabaseException;
}
