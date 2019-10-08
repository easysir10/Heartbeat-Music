package com.demo.music_with_heart.service.Impl;

import com.demo.music_with_heart.dao.UserMapper;
import com.demo.music_with_heart.entity.User;
import com.demo.music_with_heart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByName(String user_id) {
        return userMapper.findByName(user_id);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }
}
