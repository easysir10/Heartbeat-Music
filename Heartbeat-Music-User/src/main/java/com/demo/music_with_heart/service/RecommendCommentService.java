package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.RecommendComment;

import java.util.List;

public interface RecommendCommentService {
    List<RecommendComment> findByCommentRecommendList(String recommend_name);
    int totalRecommendComment(String recommend_name);
    int InsertComment(RecommendComment recommendComment);
}
