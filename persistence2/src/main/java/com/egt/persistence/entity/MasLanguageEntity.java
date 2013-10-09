package com.egt.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:36 น.
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MAS_LANGUAGE", schema = BaseEntity.SCHEMA)
public class MasLanguageEntity extends BaseEntity implements Serializable {
    @Column(name="language_code",nullable = false,unique = true,length = 2)
    private String languageCode; //en , th

    @Column(name="language_txt",nullable = false,unique = true,length = 25)
    private String languageText; //English , Thailand

    @Column(name="local",nullable = false,unique = false,length = 25)
    private String local; //US , TH

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageText() {
        return languageText;
    }

    public void setLanguageText(String languageText) {
        this.languageText = languageText;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
