package com.demo.music_with_heart.controller;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.service.RankService;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RankController {
    @Autowired
    RankService rankService;

    @GetMapping("/rank")
    public String rank(Model model){
        Date time=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String strLastTime = df.format(new Date(time.getTime() - 20 * 24 * 60 * 60 * 1000));
        String strNowTime = df.format(new Date());
        List<Music> rankNew = rankService.rankNew(strNowTime,strLastTime);
        model.addAttribute("rankNew",rankNew);
        return "rank";
    }

    @GetMapping("/rank_hot")
    public String rankHot(Model model){
        List<Music> rankHot = rankService.rankHot();
        model.addAttribute("rankHot",rankHot);
        return "rank_hot";
    }

    @GetMapping("/rank_download")
    public String rankDownload(Model model){
        List<Music> rankDownload = rankService.rankDownload();
        model.addAttribute("rankDownload",rankDownload);
        return "rank_hot";
    }

    @GetMapping("/rank_sort")
    public String rankSort(Model model){
        List<String> rankType = rankService.rankType();
        List<String> rankSingerType = rankService.rankSingerType();
        model.addAttribute("rankSingerType",rankSingerType);
        model.addAttribute("rankType",rankType);
        return "rank_sort";
    }

    @GetMapping("/sortSongResult")
    public String rankSongSort(@RequestParam("song_type") String song_type,Model model){
        List<Music> rankSort = rankService.rankSort(song_type);
        List<String> rankType = rankService.rankType();
        List<String> rankSingerType = rankService.rankSingerType();
        model.addAttribute("rankSingerType",rankSingerType);
        model.addAttribute("rankType",rankType);
        model.addAttribute("rankSort",rankSort);
        return "rank_sort_result";
    }

    @GetMapping("/sortSingerResult")
    public String rankSingerSort(@RequestParam("singer_type") String singer_type,Model model){
        List<String> rankType = rankService.rankType();
        List<String> rankSingerType = rankService.rankSingerType();
        List<Music> rankSingerSort = rankService.rankSingerSort(singer_type);
        model.addAttribute("rankType",rankType);
        model.addAttribute("rankSingerType",rankSingerType);
        model.addAttribute("rankSingerSort",rankSingerSort);
        return "rank_sort_singer_result";
    }
}
