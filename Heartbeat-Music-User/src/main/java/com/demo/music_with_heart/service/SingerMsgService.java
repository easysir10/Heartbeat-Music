package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.entity.SingerMsg;

import java.util.List;

public interface SingerMsgService {
    SingerMsg findBySingerMsg(String singer_name);
    List<Music> findBySingerSong(String singer_name);
    int findBySingerSongTotal(String singer_name);
}
