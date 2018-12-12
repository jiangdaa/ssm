package com.ssm.service.impl;

import com.ssm.dao.MemberDao;
import com.ssm.pojo.SsmMember;
import com.ssm.service.MemberService;
import com.ssm.utils.PasswordUtils;
import com.ssm.vo.MemberVo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public SsmMember checkPassword(String username, String password) {
        MemberVo memberVo = new MemberVo();
        memberVo.setUsername(username);
        String salt = memberDao.getCurrentSalt(memberVo);
        memberVo.setPassword(PasswordUtils.generateMd5(password, salt));
        return memberDao.checkPassword(memberVo);
    }
}
