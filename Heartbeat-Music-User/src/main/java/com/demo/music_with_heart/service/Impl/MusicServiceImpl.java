package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.MusicMapper;
import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicMapper musicMapper;

    @Override
    public List<Music> recommendMusicList(int id) {
        return musicMapper.recommendMusicList(id);
    }

    @Override
    public Music playMusic(int id) {
        return musicMapper.playMusic(id);
    }

    @Override
    public int totalMusic(String recommend_name) {
        return musicMapper.totalMusic(recommend_name);
    }
}
