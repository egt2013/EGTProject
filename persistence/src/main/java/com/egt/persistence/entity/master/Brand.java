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
 * Time: 15:02 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Brand", schema = BaseData.SCHEMA)
public class Brand implements Serializable {
    @Column(length = 5,unique = true,nullable = false)
    private String code;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String description;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
