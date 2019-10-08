package com.demo.music_with_heart.controller;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.entity.SingerMsg;
import com.demo.music_with_heart.service.SingerMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SingerController {
    @Autowired
    SingerMsgService singerMsgService;

    @GetMapping("/singer")
    public String singer(HttpServletRequest request, Model model,
                         @RequestParam("singer_name") String singer_name){

        System.out.println();
        SingerMsg singerMsg = singerMsgService.findBySingerMsg(singer_name);
        List<Music> singerSongList = singerMsgService.findBySingerSong(singer_name);
        int singerSongTotal = singerMsgService.findBySingerSongTotal(singer_name);
        model.addAttribute("singerSongTotal",singerSongTotal);
        model.addAttribute("singerSongList",singerSongList);
        model.addAttribute("singerMsg",singerMsg);
        return "singer";
    }
}
