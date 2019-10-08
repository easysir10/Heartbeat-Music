package com.demo.music_with_heart.entity;

public class SingerMsg {
    private int id;
    private String singer_name;
    private String singer_content;
    private String singer_profile;
    private String singer_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public String getSinger_content() {
        return singer_content;
    }

    public void setSinger_content(String singer_content) {
        this.singer_content = singer_content;
    }

    public String getSinger_profile() {
        return singer_profile;
    }

    public void setSinger_profile(String singer_profile) {
        this.singer_profile = singer_profile;
    }

    public String getSinger_type() {
        return singer_type;
    }

    public void setSinger_type(String singer_type) {
        this.singer_type = singer_type;
    }
}
