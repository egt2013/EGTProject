package com.egt.persistence.dao;

import org.springframework.stereotype.Repository;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.User;

@Repository
public interface UserDAO {
    public void save(User user) throws DatabaseException;
    public User findUserItem(User user) throws DatabaseException;
    public boolean isUserExists(User user) throws DatabaseException;
}
