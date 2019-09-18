package com.study.heartbeatmusicmanagement.dao;

import com.study.heartbeatmusicmanagement.domain.Singer;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description
 *
 * @author Hu.Wang 2019/09/09 8:15
 */
@Mapper
public interface SingerDao {

    /**
     * 查找歌手信息
     *
     * @param searchMessage 查询信息
     * @author Hu.Wang 2019-09-10 8:37
     * @return java.util.List<com.study.heartbeatmusicmanagement.domain.Singer>
     */
    @Select("<script>"+
                "select * from `singer`"+
                "<where>"+
                    "<if test='searchMessage!=null'>"+
                        "or singer_id like concat('%',#{searchMessage},'%')"+
                        "or singer_name like concat('%',#{searchMessage},'%')"+
                        "or sex like concat('%',#{searchMessage},'%')"+
                        "or nationality like concat('%',#{searchMessage},'%')"+
                        "or style like concat('%',#{searchMessage},'%')"+
                    "</if>"+
                "</where>"+
            "</script>")
    List<Singer> findSinger(@Param("searchMessage") String searchMessage);

    /**
     * （批量）删除歌手信息
     *
     * @param singerIdList 歌手id列表
     * @author Hu.Wang 2019-09-10 8:41
     * @return int
     */
    @Delete("<script>" +
                "delete from `singer` where singer_id in"+
                "<foreach item='id' index='index' collection='singerId' open='(' separator=',' close=')'>"+
                   "#{id}"+
                "</foreach>"+
            "</script>")
    int deleteSinger(@Param("singerId") int[] singerIdList);

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
    @Insert("insert into `singer`(singer_name,sex,nationality,style) values(#{singerName},#{sex},#{nationality},#{style})")
    int insertSinger(@Param("singerName") String singerName,
                     @Param("sex") String sex,
                     @Param("nationality") String nationality,
                     @Param("style") String style);

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
    @Update("update `singer` set singer_name=#{singerName},sex=#{sex},nationality=#{nationality},style=#{style} " +
            "where singer_id=#{singerId}")
    int updateSinger(@Param("singerId") int singerId,
                     @Param("singerName") String singerName,
                     @Param("sex") String sex,
                     @Param("nationality") String nationality,
                     @Param("style") String style);
}
