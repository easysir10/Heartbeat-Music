package com.demo.music_with_heart.entity;

import java.util.Date;

public class Music {
    private int id;
    private String song_name;
    private String singer_name;
    private int song_download;
    private int song_click;
    private Date song_release;
    private String song_lyric;
    private String recommend_name;
    private String song_src;

    public String getSong_src() {
        return song_src;
    }

    public void setSong_src(String song_src) {
        this.song_src = song_src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public int getSong_download() {
        return song_download;
    }

    public void setSong_download(int song_download) {
        this.song_download = song_download;
    }

    public int getSong_click() {
        return song_click;
    }

    public void setSong_click(int song_click) {
        this.song_click = song_click;
    }

    public Date getSong_release() {
        return song_release;
    }

    public void setSong_release(Date song_release) {
        this.song_release = song_release;
    }

    public String getSong_lyric() {
        return song_lyric;
    }

    public void setSong_lyric(String song_lyric) {
        this.song_lyric = song_lyric;
    }

    public String getRecommend_name() {
        return recommend_name;
    }

    public void setRecommend_name(String recommend_name) {
        this.recommend_name = recommend_name;
    }
}
