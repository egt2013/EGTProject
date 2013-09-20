package com.egt.persistence.services;

import com.egt.persistence.dao.UserDAO;
import com.egt.persistence.dao.UserDAOImpl;
import com.egt.persistence.entity.User;

public class UserService {

	private final static UserDAO userDAO = new UserDAOImpl();
	
    public static void createOrUpdateCostCentreCodes(User user) throws Exception {
    	userDAO.save(user);
    }
}
