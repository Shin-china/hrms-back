package com.dl.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
