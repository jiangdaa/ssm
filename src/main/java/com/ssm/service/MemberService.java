package com.ssm.service;


import com.ssm.pojo.SsmMember;

public interface MemberService {

    SsmMember checkPassword(String username,String password);
}
