package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.UserMsg;

public interface UserMsgService {
    UserMsg findByUserMsg(String user_id);
}
