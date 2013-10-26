package com.egt.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:24 น.
 * To change this template use File | Settings | File Templates.
 */
//@Entity
//@Table(name="MAS_USER_GROUP" ,schema = BaseData.SCHEMA)
public class MasUserGroupData extends BaseData implements Serializable {
    @Column(name="GROUP",unique = true,nullable = false,length = 400)
    private String group;
    @Column(name="MAP_ZOOM_DEFAILT")
    private int mapZoomDefault = 10;

    @ManyToOne(cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="BUSINESS_ID",insertable=true,updatable=true,nullable=false)
    private Customer customer;

    @OneToOne(cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="LANGUAGE_ID",insertable=true,updatable=true,nullable=false)
    private MasLanguageData masLanguageEntityDefault;

//    @OneToMany(mappedBy = )
//    private Set<User> masUserEntity;


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MasLanguageData getMasLanguageEntityDefault() {
        return masLanguageEntityDefault;
    }

    public void setMasLanguageEntityDefault(MasLanguageData masLanguageEntityDefault) {
        this.masLanguageEntityDefault = masLanguageEntityDefault;
    }

    public int getMapZoomDefault() {
        return mapZoomDefault;
    }

    public void setMapZoomDefault(int mapZoomDefault) {
        this.mapZoomDefault = mapZoomDefault;
    }
}
