package com.study.heartbeatmusicmanagement.domain;

import lombok.Data;

/**
 * description
 * 管理员实体类
 * @author Hu.Wang 2019/09/06 15:46
 */
@Data
public class Admin {

    private int userId;             // 用户id
    private String userNickname;    // 用户昵称
    private String userName;        // 用户姓名
    private String sex;             // 性别
    private String password;        // 密码
    private String country;         // 国家
    private String province;        // 省份
    private String city;            // 城市
    private String telephone;       // 电话
    private String qq;              // qq号
    private String email;           // 邮箱号
    private String publicFlag;      // 信息公开标志（默认隐藏）

}
