package com.egt.persistence.entity;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 16/10/2556
 * Time: 15:06 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MAS_USER_ROLE_MAPPING", schema = BaseEntity.SCHEMA)
public class MasUserRoleMappingEntity extends BaseEntity implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "USER_ID")
    @ForeignKey(name="FK_MAS_USER_MAPPING")
    private MasUserEntity masUserEntity;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "USER_ROLE_ID")
    @ForeignKey(name="FK_MAS_USER_ROLE_MAPPING")
    private MasUserRoleEntity masUserRoleEntity;

    public MasUserEntity getMasUserEntity() {
        return masUserEntity;
    }

    public void setMasUserEntity(MasUserEntity masUserEntity) {
        this.masUserEntity = masUserEntity;
    }

    public MasUserRoleEntity getMasUserRoleEntity() {
        return masUserRoleEntity;
    }

    public void setMasUserRoleEntity(MasUserRoleEntity masUserRoleEntity) {
        this.masUserRoleEntity = masUserRoleEntity;
    }
}
