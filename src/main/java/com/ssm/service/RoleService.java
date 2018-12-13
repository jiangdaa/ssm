package com.ssm.service;

import com.ssm.pojo.SsmPermission;

import java.util.List;

public interface RoleService {

    // 根据用户获取角色
    List<SsmPermission> getRoleByUser(String username);
}
