package com.ssm.web.controller;

import com.ssm.dao.MemberDao;
import com.ssm.pojo.SsmMember;
import com.ssm.utils.AjaxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberDao memberDao;

    @RequestMapping("/user")
    String memberManger() {
        return "member/user";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    Map getUserList(Integer page, Integer limit) {
        List<SsmMember> memberList = memberDao.getMemberList(page - 1, limit);
        return AjaxUtils.layuiTable(0, "成功", 2, memberList);

    }


}
