package com.egt.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * All Entities must extend this class for persistence. It does not have a backing table but ensures that all entities enforce the inclusions of mandatory columns.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    /**
     * Schema where the tables sit.
     */
    public static final String SCHEMA           = "egt";
    
    /**
     * Primary identifier, generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long                  id;

    /**
     * User who created this entity.
     */
    @Basic(optional = false)
    @Column(name = "CREATED_BY", updatable = false)
    private String                createdBy        = null;

    /**
     * User who last modified this entity.
     */
    @Basic(optional = false)
    @Column(name = "MODIFIED_BY")
    private String                modifiedBy       = null;

    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status = null;

    /**
     * Date when this entity was created.
     */
    @Basic(optional = false)
    @Column(name = "CREATE_DATE", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date                  createDate       = null;

    /**
     * Date when this entity was last modified.
     */
    @Basic(optional = false)
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date                  modifiedDate     = null;

    public Date getCreateDate() {
        return (this.createDate == null) ? null : new Date(this.createDate.getTime());
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Long getId() {
        return this.id;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public Date getModifiedDate() {
        return (this.modifiedDate == null) ? null : new Date(this.modifiedDate.getTime());
    }

    public boolean isNew() {
        return getId() == null;
    }

    /**
     * Automatically set created and modified date prior to creating the entity.
     */
    @PrePersist
    public void setCreateAndModifiedDate() {
        final Date date = new Date(System.currentTimeMillis());
        this.createDate = date;
        this.modifiedDate = date;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = (createDate == null) ? null : new Date(createDate.getTime());
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = (modifiedDate == null) ? null : new Date(modifiedDate.getTime());
    }

    /**
     * Automatically update modified date prior to update.
     */
    @PreUpdate
    public void updateModifiedDate() {
        this.modifiedDate = new Date(System.currentTimeMillis());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
