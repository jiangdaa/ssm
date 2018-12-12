package com.ssm.pojo;

import javax.persistence.Table;

@Table(name = "ssm_permission")
public class SsmPermission {

    private Integer role_id;
    private String role_name;
    private String permissions;
    private String getPermissions_name;

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

    public String getGetPermissions_name() {
        return getPermissions_name;
    }

    public void setGetPermissions_name(String getPermissions_name) {
        this.getPermissions_name = getPermissions_name;
    }
}
