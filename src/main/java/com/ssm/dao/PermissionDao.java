package com.ssm.dao;

import com.ssm.pojo.SsmPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {

    List<SsmPermission> findPermissionsByRoleIds(@Param("roleIds") String roleIds);
}
