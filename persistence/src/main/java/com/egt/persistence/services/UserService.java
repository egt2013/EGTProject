package com.egt.persistence.services;

import com.egt.persistence.entity.User;


public interface UserService {

    public void createOrUpdateCostCentreCodes(User user) throws Exception;
}
