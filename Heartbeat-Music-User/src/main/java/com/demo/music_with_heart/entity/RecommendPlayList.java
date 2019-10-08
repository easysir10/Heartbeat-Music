package com.demo.music_with_heart.entity;

import java.util.Date;

public class RecommendPlayList {
    private int id;
    private String recommend_name;
    private Date recommend_start;
    private String recommend_content;
    private String recommend_album;

    public String getRecommend_album() {
        return recommend_album;
    }

    public void setRecommend_album(String recommend_album) {
        this.recommend_album = recommend_album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecommend_name() {
        return recommend_name;
    }

    public void setRecommend_name(String recommend_name) {
        this.recommend_name = recommend_name;
    }

    public Date getRecommend_start() {
        return recommend_start;
    }

    public void setRecommend_start(Date recommend_start) {
        this.recommend_start = recommend_start;
    }

    public String getRecommend_content() {
        return recommend_content;
    }

    public void setRecommend_content(String recommend_content) {
        this.recommend_content = recommend_content;
    }


}
