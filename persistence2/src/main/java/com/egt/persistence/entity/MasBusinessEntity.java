package com.egt.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 12:23 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MAS_BUSINESS", schema = BaseEntity.SCHEMA)
public class MasBusinessEntity extends BaseEntity implements Serializable {
    @Column(name="business",unique = true,nullable = false,length = 5)
    private String business;

    @Column(name="business_text",unique = true,nullable = false,length = 400)
    private String businessText;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<MasCustomerEntity> masCustomerEntitySet;

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinessText() {
        return businessText;
    }

    public void setBusinessText(String businessText) {
        this.businessText = businessText;
    }

    public Set<MasCustomerEntity> getMasCustomerEntitySet() {
        return masCustomerEntitySet;
    }

    public void setMasCustomerEntitySet(Set<MasCustomerEntity> masCustomerEntitySet) {
        this.masCustomerEntitySet = masCustomerEntitySet;
    }
}
