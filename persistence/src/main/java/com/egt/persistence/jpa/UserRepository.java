package com.egt.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.User;

@Repository
public interface UserRepository {
    public void save(User user) throws DatabaseException;
    public User findUserItem(User user) throws DatabaseException;
    public boolean isUserExists(User user) throws DatabaseException;
}
