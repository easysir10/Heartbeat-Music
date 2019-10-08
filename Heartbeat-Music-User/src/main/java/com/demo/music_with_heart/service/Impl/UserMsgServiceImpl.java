package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.UserMsgMapper;
import com.demo.music_with_heart.entity.UserMsg;
import com.demo.music_with_heart.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMsgServiceImpl implements UserMsgService {
    @Autowired
    UserMsgMapper userMsgMapper;

    @Override
    public UserMsg findByUserMsg(String user_id) {
        return userMsgMapper.findByUserMsg(user_id);
    }
}
