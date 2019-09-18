package com.study.heartbeatmusicmanagement.service;

import com.study.heartbeatmusicmanagement.domain.Singer;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:16
 */
public interface SingerService {


    /**
     * 查找歌手信息
     *
     * @param searchMessage 查询信息
     * @author Hu.Wang 2019-09-10 8:37
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Singer>
     */
    List<Singer> findSinger(String searchMessage);

    /**
     * （批量）删除歌手信息
     *
     * @param singerIdList 歌手id列表
     * @author Hu.Wang 2019-09-10 8:41
     * @return int
     */
    int deleteSinger(int[] singerIdList);

    /**
     * 增加歌手（插入歌手信息）
     *
     * @param singerName    歌手名
     * @param sex           性别
     * @param nationality   国籍
     * @param style         风格
     * @author Hu.Wang 2019-09-10 8:49
     * @return int
     */
    int insertSinger(String singerName,String sex,String nationality,String style);

    /**
     * 更新歌手信息
     *
     * @param singerId      歌手id
     * @param singerName    歌手名
     * @param sex           性别
     * @param nationality   国籍
     * @param style         风格
     * @author Hu.Wang 2019-09-10 9:11
     * @return int
     */
    int updateSinger(int singerId,String singerName,String sex,String nationality,String style);
}
