package com.demo.music_with_heart.dao;


import com.demo.music_with_heart.entity.PlayList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformMapper {
    List<PlayList> findBySong(String user_id);
    int totalSong(String user_id);
    int deletePlayListSong(String user_id);
}
