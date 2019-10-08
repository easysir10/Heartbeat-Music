package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.Music;

import java.util.List;

public interface MusicService {
    List<Music> recommendMusicList(int id);
    Music playMusic(int id);
    int totalMusic(String recommend_name);
}
