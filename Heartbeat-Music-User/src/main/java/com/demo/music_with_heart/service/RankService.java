package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.Music;
import java.util.List;

public interface RankService {
    List<Music> rankNew(String strNowTime, String strLastTime);
    List<Music> rankHot();
    List<Music> rankDownload();
    List<Music> rankSort(String song_type);
    List<String> rankType();
    List<String> rankSingerType();
    List<Music> rankSingerSort(String singer_type);
}
