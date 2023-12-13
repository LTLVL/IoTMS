package com.zju.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zju.common.R;
import com.zju.pojo.Equipment;
import com.zju.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UserService extends IService<User> {
    R<Map<String,Object>> login(String name, String password);
    R<String> register(User user);
}
