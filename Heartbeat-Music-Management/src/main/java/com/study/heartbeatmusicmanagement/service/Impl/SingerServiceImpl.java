package com.study.heartbeatmusicmanagement.service.Impl;

import com.study.heartbeatmusicmanagement.dao.SingerDao;
import com.study.heartbeatmusicmanagement.domain.Singer;
import com.study.heartbeatmusicmanagement.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:16
 */
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerDao singerDao;

    /**
     * 查找歌手信息
     *
     * @param searchMessage 查询信息
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Singer>
     * @author Hu.Wang 2019-09-10 8:37
     */
    @Override
    public List<Singer> findSinger(String searchMessage) {
        return singerDao.findSinger(searchMessage);
    }

    /**
     * （批量）删除歌手信息
     *
     * @param singerIdList 歌手id列表
     * @return int
     * @author Hu.Wang 2019-09-10 8:41
     */
    @Override
    public int deleteSinger(int[] singerIdList) {
        return singerDao.deleteSinger(singerIdList);
    }

    /**
     * 增加歌手（插入歌手信息）
     *
     * @param singerName  歌手名
     * @param sex         性别
     * @param nationality 国籍
     * @param style       风格
     * @return int
     * @author Hu.Wang 2019-09-10 8:49
     */
    @Override
    public int insertSinger(String singerName, String sex, String nationality, String style) {
        return singerDao.insertSinger(singerName,sex,nationality,style);
    }

    /**
     * 更新歌手信息
     *
     * @param singerId    歌手id
     * @param singerName  歌手名
     * @param sex         性别
     * @param nationality 国籍
     * @param style       风格
     * @return int
     * @author Hu.Wang 2019-09-10 9:11
     */
    @Override
    public int updateSinger(int singerId, String singerName, String sex, String nationality, String style) {
        return singerDao.updateSinger(singerId,singerName,sex,nationality,style);
    }
}
