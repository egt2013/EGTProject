package com.egt.persistence.services;

import com.egt.core.common.exception.DatabaseException;
import com.egt.core.common.exception.LoginInvalidException;
import com.egt.persistence.entity.MasUserEntity;
import com.egt.persistence.entity.MasUserRoleEntity;
import com.egt.persistence.entity.MasUserRoleMappingEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserService {

    public void createOrUpdateUser(MasUserEntity user,MasUserRoleEntity userRoleEntity) throws DatabaseException;
    public MasUserRoleMappingEntity validateLogin(MasUserRoleMappingEntity masUserRoleMappingEntity) throws LoginInvalidException,DatabaseException;
}
