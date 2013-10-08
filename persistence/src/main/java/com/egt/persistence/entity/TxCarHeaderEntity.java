package com.egt.persistence.entity;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sakuracute
 * Date: 10/5/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TxCarHeaderEntity {
    private MasCarTypeEntity masCarTypeEntity;
    private MasCarBrandEntity masCarBrandEntity;
    private MasCarModelEntity masCarModelEntity;
    private MasCarStatusEntity masCarStatusEntity;
    private MasCarColorEntity masCarColorEntity;
    private MasTaxiRadioEntity masTaxiRadioEntity;
    private MasUserGroupEntity masUserGroupEntity;
    private TxGpsEntity txGpsEntity;
    private String carRegistration;
    private String simNo;
    private MasDriverEntity masDriverEntity;
    private Date expireDate;



}
