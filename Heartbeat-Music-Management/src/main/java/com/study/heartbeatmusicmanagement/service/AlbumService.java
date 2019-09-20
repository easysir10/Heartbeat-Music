package com.study.heartbeatmusicmanagement.service;

import com.study.heartbeatmusicmanagement.domain.Album;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/20 10:59
 */
public interface AlbumService {

    /**
     *
     *
     * @param singerId 歌手id
     * @author Hu.Wang 2019-09-20 11:01
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Album>
     */
    List<Album> findAlbum(int singerId);
}
