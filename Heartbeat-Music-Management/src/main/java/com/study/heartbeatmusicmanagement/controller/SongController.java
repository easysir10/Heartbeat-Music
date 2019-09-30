package com.study.heartbeatmusicmanagement.controller;

import com.study.heartbeatmusicmanagement.domain.Song;
import com.study.heartbeatmusicmanagement.service.AlbumService;
import com.study.heartbeatmusicmanagement.service.SingerService;
import com.study.heartbeatmusicmanagement.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    AlbumService albumService;
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
        model.addAttribute("albumList",albumService.findAlbum(-1));
        return "song_add";
    }

    @RequestMapping("/addSongDeal")
    public String addSongDeal(Model model,
                              @RequestParam("songName") String songName,
                              @RequestParam("singerId") String singerId,
                              @RequestParam("albumId") String albumId,
                              @RequestParam("style") String style,
                              @RequestParam("language") String language,
                              @RequestParam("lyricAddress") MultipartFile lyricAddress,
                              @RequestParam("audioAddress") MultipartFile audioAddress){
        songService.insertSong(Integer.parseInt(singerId),Integer.parseInt(albumId),songName,style,language,lyricAddress,audioAddress);
        model.addAttribute("message","添加成功！");
        return "song_find";
    }

    @RequestMapping("/deleteSong/{songId}")
    public String deleteSinger(@PathVariable("songId") String songId, RedirectAttributes attr){
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

    @RequestMapping("/updateSong")
    public String updateSong(@RequestParam("songId") String songId,
                             @RequestParam("songName") String songName,
                             @RequestParam("language") String language,
                             @RequestParam("style") String style,
                             @RequestParam("lyricAddress") MultipartFile lyricAddress,
                             @RequestParam("audioAddress") MultipartFile audioAddress,
                             RedirectAttributes attr){
        songService.updateSong(songId,songName,style,language,lyricAddress,audioAddress);
        attr.addFlashAttribute("message", "修改成功！");
        return "redirect:/song/findSong";
    }
}
