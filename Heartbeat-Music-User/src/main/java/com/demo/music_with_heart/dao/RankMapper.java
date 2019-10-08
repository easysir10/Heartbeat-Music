package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.Music;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {
    List<Music> rankNew(@Param("strNowTime") String strNowTime,@Param("strLastTime")String strLastTime);
    List<Music> rankHot();
    List<Music> rankDownload();
    List<Music> rankSort(String song_type);
    List<String> rankType();
    List<String> rankSingerType();
    List<Music> rankSingerSort(String singer_type);
}
