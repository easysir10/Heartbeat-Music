package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.Music;

import java.util.List;

public interface SearchService {
    List<Music> search(String searchName);
    int totalSearch(String searchName);
}
