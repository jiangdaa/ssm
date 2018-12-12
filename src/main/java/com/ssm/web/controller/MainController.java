package com.ssm.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @RequestMapping("/main")
    String main() {
        SecurityUtils.getSubject().hasRole("bbbb");
        return "main";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("/main/add")
    String add(){

        return "add";
    }

    @RequiresPermissions("user:del")
    @RequestMapping("/main/del")
    String del(){

        return "del";
    }

}
