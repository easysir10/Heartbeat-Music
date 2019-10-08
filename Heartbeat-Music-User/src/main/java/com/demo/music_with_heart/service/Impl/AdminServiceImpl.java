package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.AdminMapper;
import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Music> adFindByMusic() {
        return adminMapper.adFindByMusic();
    }

    @Override
    public int delMusic(int id) {
        return adminMapper.delMusic(id);
    }

    @Override
    public Music adFindByMusicMsg(String song_name, String singer_name) {
        return adminMapper.adFindByMusicMsg(song_name, singer_name);
    }


}
