package com.dl.controller;

import com.dl.pojo.Result;
import com.dl.pojo.User;
import com.dl.service.UserService;
import com.dl.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, @Pattern(regexp = "^\\s${5,16}$") String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //No user in database
            userService.register(username,password);
            return Result.success();
        }else{
            return Result.error("User already exist");
        }

    }

    @PostMapping("/login")
    public Result login(String  username, @Pattern(regexp = "^\\s${5,16}$") String password) {
        User loginname = userService.findByUserName(username);
        if (loginname == null) {
            return Result.error("User does not exist");
        }else{
            if (loginname.getPassword().equals(Md5Util.getMD5String(password))) {
                return Result.success(loginname);
            }else{
                return Result.error("Wrong password");
            }
        }
    }
}
