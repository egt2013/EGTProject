package com.egt.persistence.dao;

import org.junit.Test;

import com.egt.persistence.entity.User;
import com.egt.persistence.services.UserService;

public class TestUserDAO extends AbstractJPATest{
	
	@Test
	public void testCascadeOrderToOrderItem() throws Exception {
		UserService service = new UserService();
		User user = new User();
		user.setId(1l);
		user.setUserName("tip");
		user.setPassword("dddd");
		service.createOrUpdateCostCentreCodes(user);
 	}
}
