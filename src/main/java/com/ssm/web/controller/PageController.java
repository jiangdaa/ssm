package com.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {


    @RequestMapping("/{rootPath}/{action}/{methods}")
    String autoRenderPage(@PathVariable("rootPath") String rootPath, @PathVariable("action") String action, @PathVariable("methods") String methods) {
        return rootPath + "/" + action + "/" + methods;
    }

    @RequestMapping("/aaa")
    String aaa(Model model) {
        model.addAttribute("aaa", "值:aaa");
        return "a";
    }
}
