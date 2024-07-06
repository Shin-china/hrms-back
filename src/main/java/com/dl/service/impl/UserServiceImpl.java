package com.dl.service.impl;

import com.dl.mapper.UserMapper;
import com.dl.pojo.User;
import com.dl.service.UserService;
import com.dl.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(String username, String password) {
        //加密处理 MD5
        String md5Util = Md5Util.getMD5String(password);

        //添加
        userMapper.insert(username,md5Util);

    }

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }
}
