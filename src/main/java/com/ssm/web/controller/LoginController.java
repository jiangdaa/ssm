package com.ssm.web.controller;

import com.ssm.pojo.SsmMember;
import com.ssm.service.MemberService;
import com.ssm.utils.AjaxUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    Map checkPassword(String username, String password) {
        SsmMember ssmMember = memberService.checkPassword(username, password);
        Integer code = AjaxUtils.SUCCESS_CODE;
        String msg = "登录成功";
        if (null == ssmMember) {
            code = AjaxUtils.ERROR_CODE;
            msg = "账号密码错误";
        } else {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token =
                    new UsernamePasswordToken(ssmMember.getUsername(), ssmMember.getPassword());
            subject.login(token);

        }
        return new AjaxUtils(code, msg, ssmMember).run();
    }


}
