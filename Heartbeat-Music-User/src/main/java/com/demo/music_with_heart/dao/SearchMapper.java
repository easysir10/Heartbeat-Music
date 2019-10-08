package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchMapper {
    List<Music> search(String searchName);
    int totalSearch(String searchName);
}
