package com.ssm.service;

import com.ssm.pojo.SsmMenu;

import java.util.List;

public interface PermissionService {

    // 根据用户名获取菜单
    List<SsmMenu> getPermissionMenu(String username);
}
