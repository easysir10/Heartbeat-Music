package com.demo.music_with_heart.controller;

import com.demo.music_with_heart.entity.*;
import com.demo.music_with_heart.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RecommendController {
    @Autowired
    private UserMsgService userMsgService;

    @Autowired
    MusicService musicService;

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private RecommendCommentService recommendCommentService;

    @GetMapping("/recommend_list")
    public String Recommend_List(HttpServletRequest request, Model model,
                                 @RequestParam("id") int id,
                                 @RequestParam("recommend_name") String recommend_name) {
        request.getSession().setAttribute("recommend_name",recommend_name);
        RecommendPlayList rpl = recommendService.findByOneRecommendPlayList(recommend_name);
        int RecommendTotal = musicService.totalMusic(recommend_name);
        int RecommendCommentTotal = recommendCommentService.totalRecommendComment(recommend_name);
        model.addAttribute("totalRecommendComment",RecommendCommentTotal);
        model.addAttribute("totalRecommend",RecommendTotal);
        model.addAttribute("recommendPlayList",rpl);
        List<RecommendComment> musicComments = recommendCommentService.findByCommentRecommendList(recommend_name);
        List<Music> musicList = musicService.recommendMusicList(id);
        model.addAttribute("recommend_id",id);
        model.addAttribute("recommend_name",recommend_name);
        model.addAttribute("musicComments",musicComments);
        model.addAttribute("musicList",musicList);
        return "recommend_list";
    }

    @ResponseBody
    @PostMapping("/InsertComment")
    public String InsertComment(HttpServletRequest request,@RequestParam("comment") String user_comment
                                ){
        String user_id = (String)request.getSession().getAttribute("user_id");
        String recommend_name = (String)request.getSession().getAttribute("recommend_name");
        UserMsg userMsg = userMsgService.findByUserMsg(user_id);
        String user_name = userMsg.getUser_name();
        String user_profile = userMsg.getUser_profile();

        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);

        RecommendComment rc = new RecommendComment();
        rc.setRecommend_name(recommend_name);
        rc.setUser_comment(user_comment);
        rc.setUser_id(user_id);
        rc.setUser_name(user_name);
        rc.setUser_profile(user_profile);
        rc.setUser_comment_time(current);
        recommendCommentService.InsertComment(rc);
//        request.getSession().setAttribute("recommend_name",null);
//        request.getSession().setAttribute("id",null);
        return "评论成功";
    }
}
