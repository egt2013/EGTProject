package com.egt.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.egt.persistence.dao.UserDAO;
import com.egt.persistence.dao.UserDAOImpl;
import com.egt.persistence.services.UserService;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.egt.persistence" })
@ImportResource({ "classpath:persistence-context.xml" })
public class PersistenceJPAConfigXml {
    public PersistenceJPAConfigXml() {
        super();
        
    }
    
    @Bean
    public UserDAO userDAO() {
    	UserDAO userDAO = new UserDAOImpl();
        // set properties, etc.
        return userDAO;
    }
    
    @Bean
    public UserService userService() {
    	UserService userService = new UserService();
        // set properties, etc.
        return userService;
    }

}
