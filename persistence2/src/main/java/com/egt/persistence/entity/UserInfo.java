package com.egt.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: Porntip
 * Date: 9/10/2556
 * Time: 12:28 น.
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class UserInfo {
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="NICK_NAME")
    private String nickName;

    public UserInfo(){

    }

    public UserInfo(String firstName, String lastName, String nickName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
