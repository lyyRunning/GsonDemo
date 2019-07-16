package com.function.luo.gsondemo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luo on 2019/7/16.
 */

public class UserGroup implements Serializable {

    private  String organization;
    private List<User> list ;

    public UserGroup() {
    }

    public UserGroup(String organization, List<User> list) {
        this.organization = organization;
        this.list = list;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
