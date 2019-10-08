package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.RankMapper;
import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    RankMapper rankMapper;

    @Override
    public List<Music> rankNew(String strNowTime, String strLastTime) {
        return rankMapper.rankNew(strNowTime,strLastTime);
    }

    @Override
    public List<Music> rankHot() {
        return rankMapper.rankHot();
    }

    @Override
    public List<Music> rankDownload() {
        return rankMapper.rankDownload();
    }

    @Override
    public List<Music> rankSort(String song_type) {
        return rankMapper.rankSort(song_type);
    }

    @Override
    public List<String> rankType() {
        return rankMapper.rankType();
    }

    @Override
    public List<String> rankSingerType() {
        return rankMapper.rankSingerType();
    }

    @Override
    public List<Music> rankSingerSort(String singer_type) {
        return rankMapper.rankSingerSort(singer_type);
    }


}
