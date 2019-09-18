package com.study.heartbeatmusicmanagement.domain;

import lombok.Data;

/**
 * description
 * 歌曲实体类
 * @author Hu.Wang 2019/09/09 8:17
 */
@Data
public class Song {

    private int SongId;         // 歌曲id
    private int singerId;       // 歌手id
    private String singerName;  // 歌手名
    private int albumId;        // 专辑id
    private String albumName;   // 专辑名
    private String songName;    // 歌曲名
    private String style;       // 歌曲风格
    private String language;    // 语言
    private String lyricAddress;// 歌词地址
    private String audioAddress;// 音频地址
    private int playTimes;      // 播放量
    private int downloadTimes;  // 下载量
    private int searchTimes;    // 查询次数
    private String uploadTime;  // 上传时间
    private String bk_img;      // 歌曲背景图

}
