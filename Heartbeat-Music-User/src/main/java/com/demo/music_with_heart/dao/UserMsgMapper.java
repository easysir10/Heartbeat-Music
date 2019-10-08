package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.UserMsg;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMsgMapper {
    UserMsg findByUserMsg(String user_id);

}
