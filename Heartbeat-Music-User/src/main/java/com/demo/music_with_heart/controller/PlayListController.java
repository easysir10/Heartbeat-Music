package com.demo.music_with_heart.controller;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.entity.PlayList;
import com.demo.music_with_heart.entity.UserMsg;
import com.demo.music_with_heart.service.MusicService;
import com.demo.music_with_heart.service.PlatformService;
import com.demo.music_with_heart.service.UserMsgService;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class PlayListController {
    @Autowired
    private PlatformService platformService;

    @Autowired
    MusicService musicService;

    @Autowired
    UserMsgService userMsgService;

    @GetMapping("/play_list")
    public String playList(HttpServletRequest request,Model model){
        String user_id = (String) request.getSession().getAttribute("user_id");
        List<PlayList> pl = platformService.findBySong(user_id);
        UserMsg userMsg = userMsgService.findByUserMsg(user_id);
        int totalSong = platformService.totalSong(user_id);
        model.addAttribute("totalSong",totalSong);
        model.addAttribute("userMsg" , userMsg);
        model.addAttribute("Songlist" , pl);
        return "play_list";
    }

    @PostMapping("/play_list")
    @ResponseBody
    public Map<String,String> play_list(@RequestParam("id") int id,Model model) throws Exception {
        Map<String, String> ret = new HashMap<String, String>();
        Music music = musicService.playMusic(id);
        String src = music.getSong_src();
        model.addAttribute("music",music);
        ret.put("src",src);
        File file=new File(src);
        FileInputStream stream=new FileInputStream(file);
        AudioFile mp3= AudioFileIO.read(file);
        System.out.println(mp3.getAudioHeader().getTrackLength());//获取歌曲播放时长
//        Player player=new Player(stream);
//        player.play();
        return ret;
    }

    @GetMapping("/delete")
    public String deletePlayListSong(@RequestParam("id") String id){
        System.out.println(id);
        platformService.deletePlayListSong(id);
        return "redirect:/play_list";
    }
}
