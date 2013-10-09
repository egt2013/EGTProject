package com.egt.persistence.entity;

import javax.persistence.*;
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
@Table(name="MAS_USER_GROUP" ,schema = BaseEntity.SCHEMA)
public class MasUserGroupEntity extends BaseEntity implements Serializable {
    @Column(name="GROUP",unique = true,nullable = false,length = 400)
    private String group;

    @Column(name="MAP_ZOOM_DEFAILT")
    private int mapZoomDefault = 10;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "FK_MAS_BUSINESS", referencedColumnName = "ID")
    private MasBusinessEntity masBusinessEntity;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LANGUAGE_ID",insertable=true,updatable=true,nullable=false)
    private MasLanguageEntity masLanguageEntityDefault;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "MAS_USER")
    private Set<MasUserEntity> masUserEntitySet;


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

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
}
