package com.egt.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.egt.persistence" })
@ImportResource({ "classpath:persistence-context.xml" })
public class PersistenceJPAConfigXml {
    public PersistenceJPAConfigXml() {
        super();
        
    }

}
