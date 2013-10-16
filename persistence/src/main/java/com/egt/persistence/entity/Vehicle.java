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

    private Brand brand;
    private Model model;
    private Color color;
    private MasTaxiRadioEntity masTaxiRadioEntity;
    private MasUserGroupData masUserGroupEntity;
    private TxGpsEntity txGpsEntity;

    @Column(unique = true,nullable = false)
    private String carRegistration;
    @Column(unique = true,nullable = false)
    private String simNo;

    private MasDriverEntity masDriverEntity;

    @Temporal(TemporalType.DATE)
    @Column
    private Date expireDate;
}
