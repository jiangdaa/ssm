package com.ssm.dao;

import com.ssm.pojo.SsmMember;
import com.ssm.vo.MemberVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberDao {
    SsmMember checkPassword(@Param("MemberVo") MemberVo memberVo);

    String getCurrentSalt(@Param("MemberVo") MemberVo memberVo);

    String getRoleIdsByUsername(@Param("MemberVo") MemberVo MemberVo);

    // 获取用户列表
    List<SsmMember> getMemberList(@Param("page")Integer page, @Param("pagesize") Integer pagesize);

}
