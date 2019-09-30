package com.study.heartbeatmusicmanagement.service.Impl;

import com.study.heartbeatmusicmanagement.dao.SongDao;
import com.study.heartbeatmusicmanagement.domain.Song;
import com.study.heartbeatmusicmanagement.service.SongService;
import com.study.heartbeatmusicmanagement.utils.LrcLoadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
     * @param lyricAddress 歌词地址
     * @param audioAddress 音频地址
     * @return int
     * @author Hu.Wang 2019-09-10 11:08
     */
    @Override
    public int insertSong(int singerId, int albumId, String songName, String style, String language, MultipartFile lyricAddress, MultipartFile audioAddress) {
        String lyricPath="E: idea-workspace Heartbeat-Music Lyric "+lyricAddress.getOriginalFilename();
        String audioPath="E: idea-workspace Heartbeat-Music Audio "+audioAddress.getOriginalFilename();

        //设置上传路径
        String path1 = "E:\\idea-workspace\\Heartbeat-Music\\Lyric\\";
        String path2 = "E:\\idea-workspace\\Heartbeat-Music\\Audio\\";

        //文件上传
        File f1 = new File(path1);
        File f2 = new File(path2);

        //判断路径是否存在，不存在则创建
        if(!f1.exists()||!f2.exists()){
            f1.mkdirs();
            f2.mkdirs();
        }
        //判断上传文件是否为空
        if(!lyricAddress.isEmpty()){
            try {
                FileOutputStream lyricOut = new FileOutputStream(path1 + lyricAddress.getOriginalFilename());
                InputStream lyricOutput=lyricAddress.getInputStream();
                byte[] bs1 = new byte[1024];
                int len1;
                while ((len1 = lyricOutput.read(bs1))!= -1) {
                    lyricOut.write(bs1, 0, len1);
                }
                lyricOut.close();
                lyricOutput.close();

                FileOutputStream audioOut = new FileOutputStream(path2 + audioAddress.getOriginalFilename());
                InputStream audioOutput=audioAddress.getInputStream();
                byte[] bs2 = new byte[1024];
                int len2;
                while ((len2 = audioOutput.read(bs2))!= -1) {
                    audioOut.write(bs2, 0, len2);
                }
                audioOut.close();
                audioOutput.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return songDao.insertSong(singerId,albumId,songName,style,language,lyricPath,audioPath);
    }

    /**
     * 更新歌曲信息
     *
     * @param songId        歌曲id
     * @param songName      歌曲名
     * @param style         风格
     * @param language      语言
     * @param lyricAddress 歌词地址
     * @param audioAddress 音频地址
     * @return int
     * @author Hu.Wang 2019-09-10 11:31
     */
    @Override
    public int updateSong(String songId, String songName, String style, String language, MultipartFile lyricAddress, MultipartFile audioAddress) {

        String lyricPath="E: idea-workspace Heartbeat-Music Lyric "+lyricAddress.getOriginalFilename();
        String audioPath="E: idea-workspace Heartbeat-Music Audio "+audioAddress.getOriginalFilename();

        //设置上传路径
        String path1 = "E:\\idea-workspace\\Heartbeat-Music\\Lyric\\";
        String path2 = "E:\\idea-workspace\\Heartbeat-Music\\Audio\\";

        //文件上传
        File f1 = new File(path1);
        File f2 = new File(path2);

        //判断路径是否存在，不存在则创建
        if(!f1.exists()||!f2.exists()){
            f1.mkdirs();
            f2.mkdirs();
        }
        //判断上传文件是否为空
        if(!lyricAddress.isEmpty()){
            try {
                FileOutputStream lyricOut = new FileOutputStream(path1 + lyricAddress.getOriginalFilename());
                InputStream lyricOutput=lyricAddress.getInputStream();
                byte[] bs1 = new byte[1024];
                int len1;
                while ((len1 = lyricOutput.read(bs1))!= -1) {
                    lyricOut.write(bs1, 0, len1);
                }
                lyricOut.close();
                lyricOutput.close();

                FileOutputStream audioOut = new FileOutputStream(path2 + audioAddress.getOriginalFilename());
                InputStream audioOutput=audioAddress.getInputStream();
                byte[] bs2 = new byte[1024];
                int len2;
                while ((len2 = audioOutput.read(bs2))!= -1) {
                    audioOut.write(bs2, 0, len2);
                }
                audioOut.close();
                audioOutput.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return songDao.updateSong(songId,songName,style,language,lyricPath,audioPath);
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
