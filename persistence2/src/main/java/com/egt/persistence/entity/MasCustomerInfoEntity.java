package com.egt.persistence.entity;

import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 9/10/2556
 * Time: 12:56 น.
 * To change this template use File | Settings | File Templates.
 */
//@Entity
//@Table(name = "MAS_CUSTOMER_INFO", schema = BaseEntity.SCHEMA)
public class MasCustomerInfoEntity extends BaseEntity implements Serializable {
    @Embedded
    private CustomerInfo customerInfo;
    private MasLanguageEntity masLanguage;
    @Embedded
    private Address address;
    private Date dateOfBirth;
    private String mobile;
    private String telNo;
    private String fax;
    private String email1;
    private String email2;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public MasLanguageEntity getMasLanguage() {
        return masLanguage;
    }

    public void setMasLanguage(MasLanguageEntity masLanguage) {
        this.masLanguage = masLanguage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
}
