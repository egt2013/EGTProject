package com.egt.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 12:23 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Customer", schema = BaseData.SCHEMA)
public class Customer extends BaseData implements Serializable {
    @Column(unique = true,nullable = false,length = 5)
    private String code;
    @Column(unique = true,nullable = false,length = 400)
    private String name;
    @Embedded
    private Address address;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}