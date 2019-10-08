package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.SingerMsgMapper;
import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.entity.SingerMsg;
import com.demo.music_with_heart.service.SingerMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerMsgServiceImpl implements SingerMsgService {
    @Autowired
    SingerMsgMapper singerMsgMapper;

    @Override
    public SingerMsg findBySingerMsg(String singer_name) {
        return singerMsgMapper.findBySingerMsg(singer_name);
    }

    @Override
    public List<Music> findBySingerSong(String singer_name) {
        return singerMsgMapper.findBySingerSong(singer_name);
    }

    @Override
    public int findBySingerSongTotal(String singer_name) {
        return singerMsgMapper.findBySingerSongTotal(singer_name);
    }
}
