package com.egt.ws.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egt.persistence.entity.UserBean;
import com.egt.persistence.services.UserService;
import com.egt.ws.model.Shop;

@Controller
@EnableTransactionManagement
@ComponentScan({ "com.egt.persistence" })
public class JSONController {
    @Autowired
    private UserService service;
	
	
	@RequestMapping(value = "/egt/{name}", method = RequestMethod.GET, 
			headers="Accept=application/json")
	@ResponseBody
	public Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "test1", "test2" });
		shop.setSuccess(true);
		return shop;

	}
	
	@RequestMapping(value = "/egtservice/{name}", method = RequestMethod.GET, 
			headers="Accept=application/json")
	@ResponseBody
	public Shop getServiceInJSON(@PathVariable String name) {
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "test1", "test2" });
		try{
			UserBean user = new UserBean();
			user.setUserName("test");
			user.setPassword("password");
			user.setModifiedBy("tip");
			user.setCreatedBy("tip");
	    	user.setCreateDate(new Date());
	    	user.setModifiedDate(new Date());
			service.createOrUpdateUser(user);
			shop.setSuccess(true);
		}catch(Exception ex){
			shop.setSuccess(false);
		}

		return shop;

	}
}
