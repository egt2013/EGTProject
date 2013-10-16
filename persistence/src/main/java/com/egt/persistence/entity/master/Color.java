package com.egt.persistence.entity.master;

import com.egt.persistence.entity.BaseData;
import com.egt.persistence.entity.MasLanguageData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:38 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Color", schema = BaseData.SCHEMA)
public class Color  implements Serializable {
    @Column(length = 5,unique = true,nullable = false)
    private String code;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String description;
}
