package com.demo.music_with_heart.controller;

import com.demo.music_with_heart.entity.*;
import com.demo.music_with_heart.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class PlatformController {
    @Autowired
    private RecommendService recommendService;

    @Autowired
    private SearchService searchService;

    @RequestMapping("/")
    public String redirect() {
        return "redirect:/login";
    }

    @GetMapping("/platform_index")
    public String platformIndex(HttpServletRequest request,Model model){
        if(request.getSession().getAttribute("userType")!=null){
            int userType = (int)request.getSession().getAttribute("userType");
            model.addAttribute("userType",userType);
        }else System.out.println(request.getSession().getAttribute("userType"));
        List<RecommendPlayList> recommendPlayList = recommendService.findByRecommendPlayList();
        model.addAttribute("rePlayList",recommendPlayList);
        return "platform_index";
    }

    @GetMapping("/search")
    public String Search(Model model,@RequestParam("search") String search){
        System.out.println(search);
        String searchName ="%"+search+"%";
        int searchTotal = searchService.totalSearch(searchName);
        List<Music> searchResult = searchService.search(searchName);
        model.addAttribute("searchTotal",searchTotal);
        model.addAttribute("search",search);
        model.addAttribute("searchResult",searchResult);
        return "search";
    }

    @RequestMapping(value="/upload",method=RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }

        file.transferTo(dir);
        System.out.println(path);
        return fileName;
    }

}
