package com.demo.music_with_heart.controller;


import com.demo.music_with_heart.entity.User;

import com.demo.music_with_heart.service.UserService;
import com.demo.music_with_heart.util.CpachaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("/login_out")
    public String login_out() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String Register(@RequestParam("user_id") String user_id,
                           @RequestParam("user_name") String user_name,
                           @RequestParam("pwd") String pwd) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        User createUser = new User();
        createUser.setUser_id(user_id);
        createUser.setUser_name(user_name);
        createUser.setUser_pwd(pwd);
        createUser.setUser_type(1);
        userService.createUser(createUser);
        return "platform_index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_id") String user_id,
                        @RequestParam("pwd") String pwd,
                        @RequestParam(value = "vcode") String vcode,
                        HttpServletRequest request, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        if(StringUtils.isEmpty(user_id)){
            return "login";
        }
        if(StringUtils.isEmpty(pwd)){
            return "login";
        }
        if(StringUtils.isEmpty(vcode)) {
            return "login";
        }
        User user = userService.findByName(user_id);
        if(!pwd.equals(user.getUser_pwd())){
            return "login";
        }
        String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
        if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
            return "login";
        }
        int userType = user.getUser_type();
        System.out.println(userType);
        request.getSession().setAttribute("loginCpacha", null);
        request.getSession().setAttribute("user_id",user.getUser_id());
        request.getSession().setAttribute("user",user);
        return "redirect:/platform_index";
    }

    @GetMapping("/get_cpacha")
    public void get_cpacha(HttpServletRequest request,
                           @RequestParam(value="value",defaultValue="4",required = false) Integer value,
                           @RequestParam(value="width",defaultValue = "98",required = false) Integer width,
                           @RequestParam(value="height",defaultValue = "33",required = false) Integer height,
                           HttpServletResponse response){
        //@RequestParam注解传入默认值：验证码为随机4个字符，宽98，高33
        CpachaUtil cu = new CpachaUtil(value,width,height);
        //生成随机验证码
        String generateVCode = cu.generatorVCode();
        request.getSession().setAttribute("loginCpacha",generateVCode);
        //传入验证码，true表示添加干扰线
        BufferedImage generateRotateVCode = cu.generatorRotateVCodeImage(generateVCode, true);
        try {
            ImageIO.write(generateRotateVCode,"gif",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
