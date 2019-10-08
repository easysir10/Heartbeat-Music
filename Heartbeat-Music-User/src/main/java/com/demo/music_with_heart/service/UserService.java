package com.demo.music_with_heart.service;

import com.demo.music_with_heart.entity.User;

import java.util.List;

public interface UserService {
    User findByName(String  user_id);
    int createUser(User user);
}
