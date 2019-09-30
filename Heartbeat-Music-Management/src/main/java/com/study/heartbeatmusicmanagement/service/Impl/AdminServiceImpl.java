package com.study.heartbeatmusicmanagement.service.Impl;

import com.study.heartbeatmusicmanagement.dao.AdminDao;
import com.study.heartbeatmusicmanagement.domain.Admin;
import com.study.heartbeatmusicmanagement.domain.Data;
import com.study.heartbeatmusicmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author Hu.Wang 2019/09/06 15:47
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    /**
     * 登录验证
     *
     * @param account  账号（邮箱号或手机号）
     * @param password 密码
     * @author Hu.Wang 2019-09-09 8:36
     * @return Admin
     */
    @Override
    public Admin loginCheck(String account,String password) {
        return adminDao.loginCheck(account,password);
    }

    @Override
    public Data findData() {
        return adminDao.findData();
    }
}
