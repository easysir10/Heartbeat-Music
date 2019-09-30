package com.study.heartbeatmusicmanagement.controller;

import com.study.heartbeatmusicmanagement.service.AdminService;
import com.study.heartbeatmusicmanagement.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * description
 *
 * @author Hu.Wang 2019/09/06 10:55
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     *
     * 跳转至登录界面
     * @author Hu.Wang 2019-09-06 10:56
     * @return java.lang.String
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 生成图片验证码并将验证码文本存入session中
     *
     * @param request  请求体
     * @param response 回复体
     * @author Hu.Wang 2019-09-06 15:29
     * @return void
     */
    @RequestMapping("/getVerifyCode")
    @ResponseBody
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //生成验证码类对象
        ImageUtil ivc = new ImageUtil();
        //获取验证码
        BufferedImage image = ivc.getImage();
        //将验证码的文本存在session中
        request.getSession().setAttribute("text", ivc.getText());
        //将验证码图片响应给客户端
        ImageUtil.output(image, response.getOutputStream());
    }

    /**
     * 管理员登录验证
     *
     * @param request  请求体
     * @param model    模型
     * @param account  账户（邮箱或手机号）
     * @param password 密码
     * @author Hu.Wang 2019-09-08 22:56
     * @return java.lang.String
     */
    @RequestMapping("/loginCheck")
    public String loginCheck(HttpServletRequest request,
                             String account,
                             String password,
                             Model model) throws IOException {
        request.setCharacterEncoding("utf-8");
        // 从当前session中获取真正的验证码
        String session_vCode=(String) request.getSession().getAttribute("text");
        // 若验证码正确，则查询数据库验证账号密码
        if(request.getParameter("captcha").equalsIgnoreCase(session_vCode)){
            if (adminService.loginCheck(account,password)!=null){
                return "redirect:/admin/index";
            }else {
                model.addAttribute("message","账号或密码有误！");
                return "login";
            }
        }else {
            model.addAttribute("message","验证码有误！");
            return "login";
        }
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("data",adminService.findData());
        return "index";
    }

}
