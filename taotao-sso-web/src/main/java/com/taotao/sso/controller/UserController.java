package com.taotao.sso.controller;

import com.alibaba.fastjson.JSON;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;





    /*@ResponseBody 注解 返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中。
        返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用*/
    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public TaotaoResult checkUserData(@PathVariable String param, @PathVariable Integer type){
        //注册时数据校验
        TaotaoResult result = userService.checkUserData(param, type);
        return result;
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult register(TbUser tbUser){
        //注册
        TaotaoResult register = userService.register(tbUser);
        return register;
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult login(String username, String password,
                              HttpServletRequest request, HttpServletResponse response){
        //登录
        TaotaoResult result = userService.login(username, password);

        if (result.getStatus()==200) {
            //把token写入到cookie
            CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
        }

        return result;
    }

    /*通过token查询用户信息*/
    @RequestMapping(value = "/user/token/{token}",method = RequestMethod.GET)
    @ResponseBody
    public String getUserByToken(@PathVariable String token,String callback){
        TaotaoResult result = userService.getUserByToken(token);
        if(StringUtils.isNotBlank(callback)){
            return callback+"("+JSON.toJSONString(result)+");";
        }
        return JSON.toJSONString(result);
    }


    @RequestMapping(value = "/user/logout/{token}",method = RequestMethod.GET)
    @ResponseBody
    public String logout(@PathVariable String token,String callback){
        //安全退出
        TaotaoResult result = userService.logout(token);
        if(StringUtils.isNotBlank(callback)){

            return callback+"("+JSON.toJSONString(result)+");";
        }
        return JSON.toJSONString(result);
    }


}
