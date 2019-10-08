package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.RecommendPlayList;

import java.util.List;

public interface RecommendService {
    List<RecommendPlayList> findByRecommendPlayList();
    RecommendPlayList findByOneRecommendPlayList(String recommend_name);

}
