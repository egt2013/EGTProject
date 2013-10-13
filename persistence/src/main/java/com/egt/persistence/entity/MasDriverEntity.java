package com.egt.persistence.entity;

import com.egt.persistence.entity.master.MasCarGroupEntity;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sakuracute
 * Date: 10/5/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MasDriverEntity {
    private MasCarGroupEntity masCarGroupEntity;
    private Set<MasDriverInfoEntity> masDriverInfoEntitySet;
    private String documentPath;
}
