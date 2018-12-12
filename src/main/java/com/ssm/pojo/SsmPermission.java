package com.ssm.pojo;

import javax.persistence.Table;

@Table(name = "ssm_permission")
public class SsmPermission {

    private Integer role_id;
    private String role_name;
    private String permissions;
    private String permissions_name;


    @Override
    public String toString() {
        return "SsmPermission{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", permissions='" + permissions + '\'' +
                ", getPermissions_name='" + permissions_name + '\'' +
                '}';
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions_name() {
        return permissions_name;
    }

    public void setPermissions_name(String permissions_name) {
        this.permissions_name = permissions_name;
    }


}
