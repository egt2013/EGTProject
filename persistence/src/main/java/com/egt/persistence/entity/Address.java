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

    private String address;
    private String address1;
    private String province;
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
}
