package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.entity.RecommendPlayList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendListMapper {
    List<RecommendPlayList> findByRecommendPlayList();
    RecommendPlayList findByOneRecommendPlayList(String recommend_name);

}
