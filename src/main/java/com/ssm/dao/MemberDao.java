package com.ssm.dao;

import com.ssm.pojo.SsmMember;
import com.ssm.vo.MemberVo;
import org.apache.ibatis.annotations.Param;

public interface MemberDao {
    SsmMember checkPassword(@Param("MemberVo") MemberVo memberVo);

    String getCurrentSalt(@Param("MemberVo") MemberVo memberVo);
}
