package com.zju.controller;

import com.zju.common.R;
import com.zju.pojo.User;
import com.zju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<Map<String,Object>> login(@RequestBody User user){
        return userService.login(user.getName(), user.getPassword());
    }

    @PostMapping("/register")
    public R<String> register(@RequestBody User user){
        return userService.register(user);
    }
}
