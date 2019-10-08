package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.Music;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    List<Music> adFindByMusic();
    Music adFindByMusicMsg(@Param("song_name") String song_name,@Param("singer_name") String singer_name);
    int delMusic(int id);
}
