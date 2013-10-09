package com.egt.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 9/10/2556
 * Time: 12:24 น.
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class Address {
    @Column(name="ADDRESS1")
    private String address1;
    @Column(name="ADDRESS2")
    private String address2;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="ZIP_CODE")
    private String zip;

    public Address(){

    }

    public Address(String address1 , String address2 , String city, String state , String zip){
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
