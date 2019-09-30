package com.study.heartbeatmusicmanagement.service;

import com.study.heartbeatmusicmanagement.domain.Admin;
import com.study.heartbeatmusicmanagement.domain.Data;

/**
 * description
 *
 * @author Hu.Wang 2019/09/06 15:46
 */
public interface AdminService {

    /**
     * 登录验证
     *
     * @param account  账号（邮箱号或手机号）
     * @param password 密码
     * @author Hu.Wang 2019-09-09 8:36
     * @return Admin
     */
    Admin loginCheck(String account,String password);

    Data findData();
}
