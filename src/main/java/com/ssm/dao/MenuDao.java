package com.ssm.dao;

import com.ssm.pojo.SsmMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    List<SsmMenu> findActionByPermissionIds(@Param("ids") String ids, @Param("type") Integer type);
}
