package com.study.heartbeatmusicmanagement.controller;

import com.study.heartbeatmusicmanagement.domain.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.heartbeatmusicmanagement.service.SingerService;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:14
 */
@Controller
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    SingerService singerService;

    @RequestMapping("/findSinger")
    public String findSinger(Model model, @ModelAttribute("message") String message){
        model.addAttribute("message",message);
        return "singer_find";
    }

    @RequestMapping("/singerMessage")
    @ResponseBody
    public List<Singer> singerMessage(){
        return singerService.findSinger("");
    }

    @RequestMapping("/addSinger")
    public String addSinger(){
        return "singer_add";
    }

    @RequestMapping("/addSingerDeal")
    public String addSingerDeal(@RequestParam("singerName") String singerName,
                                @RequestParam("sex") String sex,
                                @RequestParam("nationality") String nationality,
                                @RequestParam("style") String style,
                                Model model){
        singerService.insertSinger(singerName,sex,nationality,style);
        model.addAttribute("message","添加成功！");
        return "singer_find";
    }

    @RequestMapping("/deleteSinger/{singerId}")
    public String deleteSinger(@PathVariable("singerId") String singerId, RedirectAttributes attr){
        System.out.println(singerId);
        int [] singerIdList={Integer.parseInt(singerId)};
        singerService.deleteSinger(singerIdList);
        attr.addFlashAttribute("message", "删除成功！");
        return "redirect:/singer/findSinger";
    }

    @RequestMapping("/updateSinger")
    public String updateSinger(@RequestParam("singerId") String singerId,
                               @RequestParam("singerName") String singerName,
                               @RequestParam("sex") String sex,
                               @RequestParam("nationality") String nationality,
                               @RequestParam("style") String style,
                               RedirectAttributes attr){
        singerService.updateSinger(Integer.parseInt(singerId),singerName,sex,nationality,style);
        attr.addFlashAttribute("message", "修改成功！");
        return "redirect:/singer/findSinger";
    }

}
