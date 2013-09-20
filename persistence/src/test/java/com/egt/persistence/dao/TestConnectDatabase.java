package com.egt.persistence.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egt.core.common.exception.DatabaseException;
import com.egt.persistence.entity.User;

import junit.framework.TestCase;

public class TestConnectDatabase extends TestCase{
	@Test
	public void test(){
		System.out.println("sss");
		ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
		System.out.println("aaa");
		UserDAO userDao = (UserDAO) context.getBean("userDAO");
//		User user = new User();
//		user.setId(1l);
//		user.setUserName("sss");
//		user.setPassword("ddd");
//		try {
//			userDao.save(user);
//			System.out.println("dddd");
//		} catch (DatabaseException e) {
//			e.printStackTrace();
//			System.out.println(e.toString());
//		}
		
	}
}
