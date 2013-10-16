package com.egt.persistence.entity;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:24 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends BaseData implements Serializable {
    @ManyToOne
    private MasUserGroupData masUserGroupEntity;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Embedded
    private Person person;



}
