package com.study.heartbeatmusicmanagement.dao;

import com.study.heartbeatmusicmanagement.domain.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:17
 */
@Mapper
public interface SongDao {

    /**
     * 查找歌曲信息
     *
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Song>
     * @author Hu.Wang 2019-09-10 10:17
     */
    @Select("<script>" +
                "SELECT " +
                    "s.song_id,s.singer_id,s.album_id,s.upload_time,s.style,s.song_name," +
                    "s.search_times,s.play_times,s.lyric_address,s.LANGUAGE,s.download_times," +
                    "s.audio_address,s1.singer_name,a.album_name " +
                "FROM " +
                    "`song` s," +
                    "`singer` s1," +
                    "`album` a" +
                "<where>" +
                    "AND s.singer_id = s1.singer_id " +
                    "AND s.album_id = a.album_id " +
                "</where>" +
            "</script>")
    List<Song> findSong();

    /**
     * （批量删除）删除歌曲信息
     *
     * @param songIdList 歌曲id
     * @author Hu.Wang 2019-09-10 10:54
     * @return int
     */
    @Delete("<script>" +
                "delete from `song` where song_id in" +
                "<foreach item='id' index='index' collection='songId' open='(' separator=',' close=')'>" +
                    "#{id}" +
                "</foreach>" +
            "</script>")
    int deleteSong(@Param("songId") int[] songIdList);

    /**
     * 插入歌曲信息
     *
     * @param singerId      歌手id
     * @param albumId       专辑id
     * @param songName      歌曲名
     * @param style         风格
     * @param language      语言
     * @param lyric_address 歌词地址
     * @param audio_address 音频地址
     * @author Hu.Wang 2019-09-10 11:08
     * @return int
     */
    @Insert("insert into `song`(singer_id,album_id,song_name,style,language,lyric_address,audio_address,upload_time) " +
            "values(#{singerId},#{albumId},#{songName},#{style},#{language},#{lyric_address},#{audio_address},now())")
    int insertSong(@Param("singerId") int singerId,
                   @Param("albumId") int albumId,
                   @Param("songName") String songName,
                   @Param("style") String style,
                   @Param("language") String language,
                   @Param("lyric_address") String lyric_address,
                   @Param("audio_address") String audio_address);

    /**
     * 更新歌曲信息
     *
     * @param songId        歌曲id
     * @param singerId      歌手id
     * @param albumId       专辑id
     * @param songName      歌曲名
     * @param style         风格
     * @param language      语言
     * @param lyric_address 歌词地址
     * @param audio_address 音频地址
     * @author Hu.Wang 2019-09-10 11:31
     * @return int
     */
    @Update("update `song` set singer_id=#{singerId},album_id=#{albumId},song_name=#{songName},style=#{style}," +
            "language=#{language},lyric_address=#{lyric_address},audio_address=#{audio_address}" +
            "where song_id=#{songId}")
    int updateSong(@Param("songId") String songId,
                   @Param("singerId") int singerId,
                   @Param("albumId") int albumId,
                   @Param("songName") String songName,
                   @Param("style") String style,
                   @Param("language") String language,
                   @Param("lyric_address") String lyric_address,
                   @Param("audio_address") String audio_address);
}
