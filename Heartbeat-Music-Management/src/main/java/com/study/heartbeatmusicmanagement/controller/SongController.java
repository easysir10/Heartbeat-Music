package com.study.heartbeatmusicmanagement.controller;

import com.study.heartbeatmusicmanagement.domain.Song;
import com.study.heartbeatmusicmanagement.service.SingerService;
import com.study.heartbeatmusicmanagement.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:17
 */
@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongService songService;
    @Autowired
    SingerService singerService;

    @RequestMapping("/findSong")
    public String findSong(Model model,@ModelAttribute("message") String message){
        model.addAttribute("message",message);
        return "song_find";
    }

    @RequestMapping("/songMessage")
    @ResponseBody
    public List<Song> songMessage(){
        return songService.findSong();
    }

    @RequestMapping("/addSong")
    public String addSong(Model model){
        model.addAttribute("singerList",singerService.findSinger(""));
        return "song_add";
    }

    @RequestMapping("/deleteSong/{songId}")
    public String deleteSinger(@PathVariable("songId") String songId, RedirectAttributes attr){
        System.out.println(songId);
        int [] songIdList={Integer.parseInt(songId)};
        songService.deleteSong(songIdList);
        attr.addFlashAttribute("message", "删除成功！");
        return "redirect:/song/findSong";
    }

    @RequestMapping("/lrcLoad/{lyricAddress}")
    @ResponseBody
    public String deleteSinger(@PathVariable("lyricAddress") String lyricAddress){
        return songService.lrcLoad(lyricAddress);
    }
}
