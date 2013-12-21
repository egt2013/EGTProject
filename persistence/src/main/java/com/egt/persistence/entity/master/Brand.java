package com.egt.persistence.entity.master;

import com.egt.persistence.entity.BaseData;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 4/10/2556
 * Time: 15:02 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Brand")
public class Brand implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long                  id;

    @Column(length = 5,unique = true,nullable = false)
    private String code;

    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Model> models;


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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
