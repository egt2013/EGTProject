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
@Table(name="MAS_CUSTOMER" ,schema = BaseEntity.SCHEMA)
public class MasCustomerEntity extends BaseEntity implements Serializable {
    @Column(name="CUSTOMER",unique = true,nullable = false,length = 400)
    private String customer;

    @Column(name="MAP_ZOOM_DEFAILT")
    private int mapZoomDefault = 10;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="BUSSINESS_ID",insertable=true,updatable=true,nullable=false)
    @ForeignKey(name="FK_MAS_CUSTOMER_BUSINESS")
    private MasBusinessEntity masBusinessEntity;

    @OneToOne(fetch=FetchType.LAZY)
    @ForeignKey(name="FK_MAS_CUSTOMER_LANGUAGE")
    @JoinColumn(name="LANGUAGE_ID",insertable=true,updatable=true,nullable=false)
    private MasLanguageEntity masLanguageEntityDefault;

//    @OneToMany(fetch=FetchType.LAZY, mappedBy = "FK_MAS_CUSTOMER_USER")
//    private Set<MasUserEntity> masUserEntitySet;

//    @OneToMany(fetch=FetchType.LAZY, mappedBy="FK_MAS_CUSTOMER_INFO")
//    private Set<MasCustomerInfoEntity> masCustomerInfoEntitySet;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

//    public Set<MasUserEntity> getMasUserEntitySet() {
//        return masUserEntitySet;
//    }
//
//    public void setMasUserEntitySet(Set<MasUserEntity> masUserEntitySet) {
//        this.masUserEntitySet = masUserEntitySet;
//    }

    public MasBusinessEntity getMasBusinessEntity() {
        return masBusinessEntity;
    }

    public void setMasBusinessEntity(MasBusinessEntity masBusinessEntity) {
        this.masBusinessEntity = masBusinessEntity;
    }

    public MasLanguageEntity getMasLanguageEntityDefault() {
        return masLanguageEntityDefault;
    }

    public void setMasLanguageEntityDefault(MasLanguageEntity masLanguageEntityDefault) {
        this.masLanguageEntityDefault = masLanguageEntityDefault;
    }

    public int getMapZoomDefault() {
        return mapZoomDefault;
    }

    public void setMapZoomDefault(int mapZoomDefault) {
        this.mapZoomDefault = mapZoomDefault;
    }

//    public Set<MasCustomerInfoEntity> getMasCustomerInfoEntitySet() {
//        return masCustomerInfoEntitySet;
//    }
//
//    public void setMasCustomerInfoEntitySet(Set<MasCustomerInfoEntity> masCustomerInfoEntitySet) {
//        this.masCustomerInfoEntitySet = masCustomerInfoEntitySet;
//    }
}
