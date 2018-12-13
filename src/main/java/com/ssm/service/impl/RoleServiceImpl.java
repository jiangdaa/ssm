package com.ssm.service.impl;

import com.ssm.dao.MemberDao;
import com.ssm.dao.PermissionDao;
import com.ssm.pojo.SsmPermission;
import com.ssm.service.RoleService;
import com.ssm.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<SsmPermission> getRoleByUser(String username) {

        MemberVo memberVo = new MemberVo();
        memberVo.setUsername(username);
        // 角色id
        String roleIds = memberDao.getRoleIdsByUsername(memberVo);
        // 根据角色id查询角色名称
        return permissionDao.findPermissionsByRoleIds(roleIds);
    }
}
