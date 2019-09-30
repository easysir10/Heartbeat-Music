package com.study.heartbeatmusicmanagement.dao;

import com.study.heartbeatmusicmanagement.domain.Admin;
import com.study.heartbeatmusicmanagement.domain.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * description
 *
 * @author Hu.Wang 2019/09/06 15:46
 */
@Mapper
public interface AdminDao {

    /**
     * 登录验证
     *
     * @param account  账户（电话号码或邮箱号）
     * @param password 密码
     * @author Hu.Wang 2019-09-09 8:34
     * @return Admin
     */
    @Select("select * from `user` where password = #{password} and telephone = #{account} or email = #{account}")
    Admin loginCheck(@Param("account") String account,@Param("password") String password);

    @Select("SELECT COUNT(*) as user_count," +
            "(select sum(play_times) from song) as play_times, " +
            "(select sum(download_times) from song) as download_times, " +
            "(select sum(search_times) from song) as search_times " +
            " from user;")
    Data findData();
}
