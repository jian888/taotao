package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/21.
 */
@Controller
public class pageController {

    /*登录页面*/
    @RequestMapping("/page/login")
    public String showLogin(String url, Model model){
        model.addAttribute("redirect",url);
        return "login";
    }

    /*注册页面*/
    @RequestMapping("/page/register")
    public String showRegister(){
        return "register";
    }

}
