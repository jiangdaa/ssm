package com.ssm.web.controller;

import com.google.gson.Gson;
import com.ssm.pojo.SsmMenu;
import com.ssm.service.PermissionService;
import com.ssm.utils.PermissionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/main")
    String main(Model model) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username != null) {
            List<SsmMenu> permissionMenu = permissionService.getPermissionMenu(username);
            List<SsmMenu> ssmMenus = PermissionUtils.disposeMenu(0, permissionMenu);
            model.addAttribute("menu", ssmMenus);
            Gson gson = new Gson();
           // System.out.println(gson.toJson(ssmMenus));
        } else {
            return "redirect:login";
        }
        return "main";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("/main/add")
    String add() {

        return "add";
    }

    @RequiresPermissions("user:del")
    @RequestMapping("/main/del")
    String del() {

        return "del";
    }

    @RequestMapping("/home")
    String home(){
        return "home";
    }

}
