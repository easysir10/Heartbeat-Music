package com.study.heartbeatmusicmanagement.service.Impl;

import com.study.heartbeatmusicmanagement.dao.SongDao;
import com.study.heartbeatmusicmanagement.domain.Song;
import com.study.heartbeatmusicmanagement.service.SongService;
import com.study.heartbeatmusicmanagement.utils.LrcLoadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:17
 */
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongDao songDao;

    /**
     * 查找歌曲信息
     *
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Song>
     * @author Hu.Wang 2019-09-10 10:17
     */
    @Override
    public List<Song> findSong() {
        return songDao.findSong();
    }

    /**
     * （批量删除）删除歌曲信息
     *
     * @param songIdList 歌曲id
     * @return int
     * @author Hu.Wang 2019-09-10 10:54
     */
    @Override
    public int deleteSong(int[] songIdList) {
        return songDao.deleteSong(songIdList);
    }

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
     * @return int
     * @author Hu.Wang 2019-09-10 11:08
     */
    @Override
    public int insertSong(int singerId, int albumId, String songName, String style, String language, String lyric_address, String audio_address) {
        return songDao.insertSong(singerId,albumId,songName,style,language,lyric_address,audio_address);
    }

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
     * @return int
     * @author Hu.Wang 2019-09-10 11:31
     */
    @Override
    public int updateSong(String songId, int singerId, int albumId, String songName, String style, String language, String lyric_address, String audio_address) {
        return songDao.updateSong(songId,singerId,albumId,songName,style,language,lyric_address,audio_address);
    }

    /**
     * 获取歌词内容
     *
     * @param lyricAddress 歌词地址
     * @return java.lang.String
     * @author Hu.Wang 2019-09-17 10:32
     */
    @Override
    public String lrcLoad(String lyricAddress) {
        LrcLoadUtil lrcLoadUtil=new LrcLoadUtil();
        List<Map<Long, String>> list = lrcLoadUtil.parse(lyricAddress.replace(" ","\\"));
        if (list == null || list.isEmpty()) {
            return "没有任何歌词信息！";
        } else {
            StringBuilder lrc= new StringBuilder();
            for (Map<Long, String> map : list) {
                for (Map.Entry<Long, String> entry : map.entrySet()) {
                    lrc.append(entry.getValue()).append("-");
                }
            }
            return lrc.toString();
        }

    }
}
