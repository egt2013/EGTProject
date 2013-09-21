package com.egt.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egt.persistence.config.PersistenceJPAConfigXml;
import com.egt.persistence.services.UserService;
import com.egt.ws.model.Shop;

@Controller
@EnableTransactionManagement
@ComponentScan({ "com.egt.persistence" })
@ImportResource({ "*persistence-context.xml" })
public class JSONController {
	@Autowired
	public UserService service;
	
	
	@RequestMapping(value = "/egt/{name}", method = RequestMethod.GET, 
			headers="Accept=application/json")
	@ResponseBody
	public Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "test1", "test2" });
		return shop;

	}
}
