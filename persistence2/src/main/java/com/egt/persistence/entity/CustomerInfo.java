package com.egt.persistence.entity;

import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 9/10/2556
 * Time: 12:27 น.
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class CustomerInfo {
    private String companyName;

    public CustomerInfo(){

    }

    public CustomerInfo(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
