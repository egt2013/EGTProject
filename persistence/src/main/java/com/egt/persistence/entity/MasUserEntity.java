package com.egt.persistence.entity;
import javax.persistence.ManyToOne;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 11:24 น.
 * To change this template use File | Settings | File Templates.
 */

public class MasUserEntity extends BaseEntity {
    @ManyToOne
    private MasUserGroupEntity masUserGroupEntity;
    private String username;
    private String password;
    private Set<MasUserInfoEntity> masUserInfoEntitySet;



}
