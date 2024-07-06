package com.dl.service;

import com.dl.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void register(String username, String password);

    User findByUserName(String username);
}
