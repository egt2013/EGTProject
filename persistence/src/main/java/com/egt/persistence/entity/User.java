package com.egt.persistence.entity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:24 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends BaseData {
    @ManyToOne
    private MasUserGroupData masUserGroupEntity;
    private String username;
    private String password;

    @Embedded
    private Person person;



}
