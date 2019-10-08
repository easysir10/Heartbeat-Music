package com.demo.music_with_heart.dao;

import com.demo.music_with_heart.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User findByName(String user_id);
    int createUser(User user);
}
