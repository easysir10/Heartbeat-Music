package com.study.heartbeatmusicmanagement.dao;

import com.study.heartbeatmusicmanagement.domain.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/20 10:32
 */
@Mapper
public interface AlbumDao {

    /**
     *
     *
     * @param singerId 歌手id
     * @author Hu.Wang 2019-09-20 10:59
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Album>
     */
    @Select("<script>"+
                "select `album`.album_id,`album`.album_name,`album`.singer_id,`singer`.singer_name,`album`.publish_time," +
                " `album`.bk_img from `album`,`singer` "+
                    "<where>"+
                        "<if test='singerId!=-1'>"+
                            " or singer_id = #{singerId} "+
                        "</if>"+
                        " and `album`.singer_id=`singer`.singer_id "+
                    "</where>"+
            "</script>")
    List<Album> findAlbum(@Param("singerId") int singerId);
}
