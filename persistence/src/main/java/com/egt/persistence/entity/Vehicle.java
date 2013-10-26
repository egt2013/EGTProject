package com.egt.persistence.entity;

import com.egt.persistence.entity.master.Brand;
import com.egt.persistence.entity.master.Color;
import com.egt.persistence.entity.master.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: naipao
 * Date: 15/10/13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Vehicle", schema = BaseData.SCHEMA)
public class Vehicle extends BaseData  implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id",nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Color color;

//    private MasTaxiRadioEntity masTaxiRadioEntity;
//    private MasUserGroupData masUserGroupEntity;
//    private TxGpsEntity txGpsEntity;

    @Column(unique = true,nullable = false)
    private String carRegistration;
    @Column(unique = true,nullable = false)
    private String simNo;

//    private MasDriverEntity masDriverEntity;

    @Temporal(TemporalType.DATE)
    @Column
    private Date expireDate;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
