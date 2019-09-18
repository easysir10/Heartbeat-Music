package com.study.heartbeatmusicmanagement.domain;

import lombok.Data;

/**
 * description
 * 歌手实体类
 * @author Hu.Wang 2019/09/09 8:15
 */
@Data
public class Singer {

    private int singerId;       // 歌手id
    private String singerName;  // 歌手名
    private String sex;         // 性别
    private String nationality; // 国籍
    private String style;       // 风格
    private String bk_img;      // 歌手背景图

}
