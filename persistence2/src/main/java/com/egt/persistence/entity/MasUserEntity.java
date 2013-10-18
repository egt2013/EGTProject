package com.egt.persistence.entity;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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

    @Column(name="USER_LOCK",columnDefinition = "boolean default false")
    private boolean lock;

    @Column(name="USER_ENABLE",columnDefinition = "boolean default true")
    private boolean enable;

    @Column(name = "EXPIRE_DATE")
    private Date ExpireDate;

    @ManyToOne()
    @JoinColumn(name = "USER_ROLE_ID")
    @ForeignKey(name="FK_MAS_USER_ROLE_MAPPING")
    private MasUserRoleEntity masUserRoleEntity;

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

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        ExpireDate = expireDate;
    }

    public MasUserRoleEntity getMasUserRoleEntity() {
        return masUserRoleEntity;
    }

    public void setMasUserRoleEntity(MasUserRoleEntity masUserRoleEntity) {
        this.masUserRoleEntity = masUserRoleEntity;
    }

    //    public Set<MasUserInfoEntity> getMasUserInfoEntitySet() {
//        return masUserInfoEntitySet;
//    }
//
//    public void setMasUserInfoEntitySet(Set<MasUserInfoEntity> masUserInfoEntitySet) {
//        this.masUserInfoEntitySet = masUserInfoEntitySet;
//    }


    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("id="+this.getId()+"\n");
        str.append("username="+this.getUsername()+"\n");
        str.append("password="+this.getPassword()+"\n");
        str.append("enable="+this.isEnable()+"\n");
        str.append("lock="+this.isLock()+"\n");
        str.append("expireDate="+this.getExpireDate()+"\n");
        str.append("urerRole="+this.getMasUserRoleEntity().getUserRole());
        return str.toString();
    }
}
