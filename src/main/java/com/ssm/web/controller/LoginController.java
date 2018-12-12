package com.ssm.web.controller;

import com.ssm.pojo.SsmMember;
import com.ssm.service.MemberService;
import com.ssm.utils.AjaxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/login/checkPassword")
    @ResponseBody
    Map checkPassword(String username,String password){
        SsmMember ssmMember = memberService.checkPassword(username, password);
        return new AjaxUtils(AjaxUtils.SUCCESS_CODE,"成功",ssmMember).run();
    }


}
