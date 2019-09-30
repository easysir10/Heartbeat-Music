package com.study.heartbeatmusicmanagement.service;

import com.study.heartbeatmusicmanagement.domain.Song;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:17
 */
public interface SongService {

    /**
     * 查找歌曲信息
     *
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Song>
     * @author Hu.Wang 2019-09-10 10:17
     */
    List<Song> findSong();

    /**
     * （批量删除）删除歌曲信息
     *
     * @param songIdList 歌曲id
     * @author Hu.Wang 2019-09-10 10:54
     * @return int
     */
    int deleteSong(int[] songIdList);

    /**
     * 插入歌曲信息
     *
     * @param singerId      歌手id
     * @param albumId       专辑id
     * @param songName      歌曲名
     * @param style         风格
     * @param language      语言
     * @param lyricAddress 歌词地址
     * @param audioAddress 音频地址
     * @author Hu.Wang 2019-09-10 11:08
     * @return int
     */
    int insertSong(int singerId, int albumId, String songName, String style, String language, MultipartFile lyricAddress, MultipartFile audioAddress);

    /**
     * 更新歌曲信息
     *
     * @param songId        歌曲id
     * @param songName      歌曲名
     * @param style         风格
     * @param language      语言
     * @param lyricAddress 歌词地址
     * @param audioAddress 音频地址
     * @author Hu.Wang 2019-09-10 11:31
     * @return int
     */
    int updateSong(String songId,String songName,String style,String language,MultipartFile lyricAddress,MultipartFile audioAddress);

    /**
     * 获取歌词内容
     *
     * @param lyricAddress 歌词地址
     * @author Hu.Wang 2019-09-17 10:32
     * @return java.lang.String
     */
    String lrcLoad(String lyricAddress);
}
