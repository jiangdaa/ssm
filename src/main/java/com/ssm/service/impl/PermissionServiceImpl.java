package com.ssm.service.impl;

import com.ssm.dao.MemberDao;
import com.ssm.dao.MenuDao;
import com.ssm.dao.PermissionDao;
import com.ssm.pojo.SsmMenu;
import com.ssm.pojo.SsmPermission;
import com.ssm.service.PermissionService;
import com.ssm.service.RoleService;
import com.ssm.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<SsmMenu> getPermissionMenu(String username) {
        List<SsmPermission> permissionsByRoleIds = roleService.getRoleByUser(username);
        StringBuilder permissionIds = new StringBuilder();
        for (SsmPermission ssmPermission : permissionsByRoleIds) {
            permissionIds.append(ssmPermission.getPermissions()).append(",");
        }
        String disStr = permissionIds.substring(0, permissionIds.lastIndexOf(","));
        return menuDao.findActionByPermissionIds(disStr, 0);
    }
}
