package com.demo.music_with_heart.controller;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/admin_index")
    public String admin_index(Model model){
        List<Music> adMusicList = adminService.adFindByMusic();
        model.addAttribute("adMusicList",adMusicList);
        return "admin_index";
    }

    @GetMapping("/admin_singer")
    public String admin_singer(Model model){
        List<Music> adMusicList = adminService.adFindByMusic();
        model.addAttribute("adMusicList",adMusicList);
        return "admin_singer";
    }

    @GetMapping("/admin_sort")
    public String admin_sort(Model model){
        return "admin_sort";
    }

    @GetMapping("/adDel")
    public String adDel(Model model, @RequestParam("song_name") String song_name,
                        @RequestParam("singer_name") String singer_name){
        System.out.println(song_name);
        System.out.println(singer_name);
        Music musicMsg = adminService.adFindByMusicMsg(song_name, singer_name);
        adminService.delMusic(musicMsg.getId());
        return "redirect:/admin_index";
    }
}
