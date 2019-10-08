package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.PlayList;

import java.util.List;

public interface PlatformService {
    List<PlayList> findBySong(String user_id);
    int totalSong(String user_id);
    int deletePlayListSong(String user_id);
}
