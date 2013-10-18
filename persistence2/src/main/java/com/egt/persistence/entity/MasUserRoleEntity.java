package com.egt.persistence.entity;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 16/10/2556
 * Time: 14:56 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MAS_USER_ROLE", schema = BaseEntity.SCHEMA)
public class MasUserRoleEntity extends BaseEntity implements Serializable {

    @Column(name="USER_ROLE",unique = true,nullable = false,length = 400)
    private String userRole;

//    @OneToMany(fetch = FetchType.LAZY)
//    private Set<MasUserEntity> masUserEntitySet;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

//    public Set<MasUserEntity> getMasUserEntitySet() {
//        return masUserEntitySet;
//    }
//
//    public void setMasUserEntitySet(Set<MasUserEntity> masUserEntitySet) {
//        this.masUserEntitySet = masUserEntitySet;
//    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("USER_ROLE ="+this.userRole);
        return str.toString();
    }
}
