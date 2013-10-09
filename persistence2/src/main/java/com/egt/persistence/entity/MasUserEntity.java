package com.egt.persistence.entity;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:24 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MAS_USER", schema = BaseEntity.SCHEMA)
public class MasUserEntity extends BaseEntity implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    @ForeignKey(name="FK_MAS_USER_CUSTOMER")
    private MasCustomerEntity masCustomerEntity;

    @Column(name="USERNAME",unique = true,nullable = false,length = 400)
    private String username;

    @Column(name="SECRET",unique = true,nullable = false,length = 400)
    private String password;

//    @OneToMany(fetch=FetchType.LAZY, mappedBy = "FK_MAS_USER")
//    private Set<MasUserInfoEntity> masUserInfoEntitySet;

    public MasCustomerEntity getMasCustomerEntity() {
        return masCustomerEntity;
    }

    public void setMasCustomerEntity(MasCustomerEntity masCustomerEntity) {
        this.masCustomerEntity = masCustomerEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<MasUserInfoEntity> getMasUserInfoEntitySet() {
//        return masUserInfoEntitySet;
//    }
//
//    public void setMasUserInfoEntitySet(Set<MasUserInfoEntity> masUserInfoEntitySet) {
//        this.masUserInfoEntitySet = masUserInfoEntitySet;
//    }
}
