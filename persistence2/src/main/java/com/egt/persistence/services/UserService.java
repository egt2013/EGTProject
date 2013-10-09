package com.egt.persistence.services;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.persistence.entity.MasUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserService {

    public void createOrUpdateUser(MasUserEntity user) throws DatabaseException;
    public MasUserEntity validateLogin(MasUserEntity user) throws LoginInvalidException,DatabaseException;
}
