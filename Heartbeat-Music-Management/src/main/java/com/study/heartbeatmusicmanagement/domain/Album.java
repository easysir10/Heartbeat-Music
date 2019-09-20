package com.study.heartbeatmusicmanagement.domain;

import lombok.Data;

/**
 * description
 *
 * @author Hu.Wang 2019/09/20 10:28
 */
@Data
public class Album {
    private int albumId;        // 专辑id
    private int singerId;       // 歌手id
    private String singerName;  // 歌手名
    private String albumName;   // 专辑名
    private String publishTime; // 发行时间
    private String bkImg;       // 图片路径
}
