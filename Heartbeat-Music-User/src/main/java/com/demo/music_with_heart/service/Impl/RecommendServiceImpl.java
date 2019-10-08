package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.RecommendListMapper;
import com.demo.music_with_heart.entity.RecommendPlayList;
import com.demo.music_with_heart.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    RecommendListMapper recommendListMapper;

    @Override
    public List<RecommendPlayList> findByRecommendPlayList() {
        return recommendListMapper.findByRecommendPlayList();
    }

    @Override
    public RecommendPlayList findByOneRecommendPlayList(String recommend_name) {
        return recommendListMapper.findByOneRecommendPlayList(recommend_name);
    }


}
