package com.egt.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.egt.persistence.jpa.UserRepositoryImpl;
import com.egt.persistence.jpa.UserRepository;
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
    public UserRepository userDAO() {
    	UserRepository userDAO = new UserRepositoryImpl();
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
