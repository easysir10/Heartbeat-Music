package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.SearchMapper;
import com.demo.music_with_heart.entity.Music;
import com.demo.music_with_heart.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchMapper searchMapper;

    @Override
    public List<Music> search(String searchName) {
        return searchMapper.search(searchName);
    }

    @Override
    public int totalSearch(String searchName) {
        return searchMapper.totalSearch(searchName);
    }
}
