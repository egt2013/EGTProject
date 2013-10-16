package com.egt.persistence.entity.master;

import com.egt.persistence.entity.BaseData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 4/10/2556
 * Time: 15:04 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Model", schema = BaseData.SCHEMA)
public class Model implements Serializable{
    @Column(length = 5,unique = true,nullable = false)
    private String code;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String description;
}
