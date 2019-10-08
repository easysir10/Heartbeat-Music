package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.RecommendComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendCommentMapper {
    List<RecommendComment> findByCommentRecommendList(String recommend_name);
    int totalRecommendComment(String recommend_name);
    int InsertComment(RecommendComment recommendComment);
}
