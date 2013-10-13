package com.egt.persistence.entity;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 2/10/2556
 * Time: 15:43 น.
 * To change this template use File | Settings | File Templates.
 */
public class MasMenuEntity {
    private MasUserGroupData masUserGroupEntity;
    private Set<MasMenuInfoEntity> masMenuInfoEntitySet;
    private String menu;
    private MasMenuEntity masMenuMainRef;
    private int seqNo;
    private int subNo;
    private boolean isPublic;


}
