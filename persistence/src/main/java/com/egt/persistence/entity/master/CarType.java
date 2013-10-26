package com.egt.persistence.entity.master;

import com.egt.persistence.entity.BaseData;
import com.egt.persistence.entity.MasLanguageData;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 4/10/2556
 * Time: 15:16 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CarType", schema = BaseData.SCHEMA)
public class CarType  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long                  id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String description;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
