package com.egt.persistence.entity;

import com.egt.persistence.entity.master.*;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sakuracute
 * Date: 10/5/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TxCarHeaderEntity {
    private Brand brand;
    private Model model;
    private Color color;
    private MasTaxiRadioEntity masTaxiRadioEntity;
    private MasUserGroupData masUserGroupEntity;
    private TxGpsEntity txGpsEntity;
    private String carRegistration;
    private String simNo;
    private MasDriverEntity masDriverEntity;
    private Date expireDate;



}
