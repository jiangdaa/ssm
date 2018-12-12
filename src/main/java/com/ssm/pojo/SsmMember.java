package com.ssm.pojo;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "ssm_member")
public class SsmMember {
    private Integer member_id;
    private String username;
    private String password;
    private String salt;
    private Integer is_disable;
    private String role_ids;
    private Date create_time;

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() { return salt; }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getIs_disable() {
        return is_disable;
    }

    public void setIs_disable(Integer is_disable) {
        this.is_disable = is_disable;
    }

    public String getRole_ids() {
        return role_ids;
    }

    public void setRole_ids(String role_ids) {
        this.role_ids = role_ids;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
