package com.egt.persistence.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: naipao
 * Date: 13/10/13
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */

@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {

    @Column
    private String address;

    @Column
    private String address1;

    @Column
    private String province;

    @Column
    private String zipCode;
    @Column(length = 10)
    private String mobile;
    @Column(length = 10)
    private String telNo;
    @Column(length = 10)
    private String fax;

    @Email
    private String email1;
    @Email
    private String email2;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
