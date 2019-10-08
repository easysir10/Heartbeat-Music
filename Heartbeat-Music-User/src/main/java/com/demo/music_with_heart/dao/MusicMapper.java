package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicMapper {
    List<Music> recommendMusicList(int id);
    Music playMusic(int id);
    int totalMusic(String recommend_name);
}
