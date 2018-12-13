package com.ssm.web.controller;

import com.ssm.pojo.SsmMember;
import com.ssm.service.MemberService;
import com.ssm.utils.AjaxUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private SessionDAO sessionDAO;

    /**
     * 渲染登录页面
     *
     * @return String
     */
    @RequestMapping("/login")
    String login() {
        return "login";
    }

    /**
     * 验证登录账号密码
     *
     * @param username 账号
     * @param password 密码
     * @return Json
     */
    @RequestMapping(value = "/login/checkPassword", method = RequestMethod.POST)
    @ResponseBody
    Map checkPassword(String username, String password) {
        Integer code = AjaxUtils.SUCCESS_CODE;
        String msg = "登录成功";
        // 实现系统单点登录
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        if (sessions != null) {
            for (Session session : sessions) {
                System.out.println("登录用户" + session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
                if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null) {
                    code = AjaxUtils.ERROR_CODE;
                    msg = "该账号已在其它地方登录";
                    return new AjaxUtils(code, msg, null).run();
                }
            }
        }
        // 账号没有登录过
        SsmMember ssmMember = memberService.checkPassword(username, password);
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

    /**
     * 退出登录
     *
     * @return String
     */
    @RequestMapping("/logout")
    String logout() {
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        sessions.clear();
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }


}
