package com.egt.persistence.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:29 น.
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Person {

    @Column(length = 100)
    private String firstName;
    @Column(length = 100)
    private String lastName;

    @Column(length = 50)
    private String nickName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Embedded
    private Address address;


}
