package com.demo.music_with_heart.entity;

import java.util.Date;

public class RecommendComment {
    private int id;
    private String recommend_name;
    private String user_id;
    private String user_name;
    private String user_profile;
    private String user_comment;
    private String user_comment_time;

    public String getRecommend_name() {
        return recommend_name;
    }

    public void setRecommend_name(String recommend_name) {
        this.recommend_name = recommend_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public String getUser_comment_time() {
        return user_comment_time;
    }

    public void setUser_comment_time(String user_comment_time) {
        this.user_comment_time = user_comment_time;
    }
}
