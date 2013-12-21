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
@Table(name = "Customer", schema = BaseData.SCHEMA)
public class Customer extends BaseData implements Serializable {
    @Column(unique = true,nullable = false,length = 5)
    private String code;
    @Column(unique = true,nullable = false,length = 400)
    private String name;
    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Vehicle> vehicles;

    @ManyToMany
    @JoinTable(name="customer_has_user",
            joinColumns=
            @JoinColumn(name="homeId", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="personId", referencedColumnName="id")
    )
    private Set<User> users;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
