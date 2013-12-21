package com.egt.persistence.entity;

import com.egt.persistence.entity.master.Brand;
import com.egt.persistence.entity.master.Color;
import com.egt.persistence.entity.master.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
    @JoinColumn(nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Color color;

    @Column(unique = true,nullable = false)
    private String registerNo;
    @Column(unique = true,nullable = false)
    private String simNo;

    @Column(unique = true,nullable = false)
    private String engineNo;

    @Temporal(TemporalType.DATE)
    @Column
    private Date expireDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Date installDate;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<VehicleHistory> vehicleHistorys;


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

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
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

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Set<VehicleHistory> getVehicleHistorys() {
        return vehicleHistorys;
    }

    public void setVehicleHistorys(Set<VehicleHistory> vehicleHistorys) {
        this.vehicleHistorys = vehicleHistorys;
    }
}
