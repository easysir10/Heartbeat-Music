package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.Music;

import java.util.List;

public interface AdminService {
    List<Music> adFindByMusic();
    int delMusic(int id);
    Music adFindByMusicMsg(String song_name,String singer_name);
}
