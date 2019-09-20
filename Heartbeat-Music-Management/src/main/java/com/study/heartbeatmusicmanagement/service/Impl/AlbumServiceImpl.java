package com.study.heartbeatmusicmanagement.service.Impl;

import com.study.heartbeatmusicmanagement.dao.AlbumDao;
import com.study.heartbeatmusicmanagement.domain.Album;
import com.study.heartbeatmusicmanagement.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/20 11:02
 */
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDao albumDao;
    /**
     * @param singerId 歌手id
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Album>
     * @author Hu.Wang 2019-09-20 11:01
     */
    @Override
    public List<Album> findAlbum(int singerId) {
        return albumDao.findAlbum(singerId);
    }
}
