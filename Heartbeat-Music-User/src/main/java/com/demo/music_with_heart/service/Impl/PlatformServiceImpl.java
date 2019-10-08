package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.PlatformMapper;
import com.demo.music_with_heart.entity.PlayList;
import com.demo.music_with_heart.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    PlatformMapper platformMapper;


    @Override
    public List<PlayList> findBySong(String user_id) {
        return platformMapper.findBySong(user_id);
    }

    @Override
    public int totalSong(String user_id) {
        return platformMapper.totalSong(user_id);
    }

    @Override
    public int deletePlayListSong(String user_id) {
        return platformMapper.deletePlayListSong(user_id);
    }
}
