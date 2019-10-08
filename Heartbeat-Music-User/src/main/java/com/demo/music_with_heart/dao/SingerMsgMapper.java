package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.entity.SingerMsg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMsgMapper {
    SingerMsg findBySingerMsg(String singer_name);
    List<Music> findBySingerSong(String singer_name);
    int findBySingerSongTotal(String singer_name);
}
