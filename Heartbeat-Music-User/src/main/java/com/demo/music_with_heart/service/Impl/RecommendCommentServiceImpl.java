package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.RecommendCommentMapper;
import com.demo.music_with_heart.entity.RecommendComment;
import com.demo.music_with_heart.service.RecommendCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendCommentServiceImpl implements RecommendCommentService {
    @Autowired
    RecommendCommentMapper recommendCommentMapper;

    @Override
    public List<RecommendComment> findByCommentRecommendList(String recommend_name) {
        return recommendCommentMapper.findByCommentRecommendList(recommend_name);
    }

    @Override
    public int totalRecommendComment(String recommend_name) {
        return recommendCommentMapper.totalRecommendComment(recommend_name);
    }

    @Override
    public int InsertComment(RecommendComment recommendComment) {
        return recommendCommentMapper.InsertComment(recommendComment);
    }
}
