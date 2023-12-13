package com.zju.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.common.R;
import com.zju.mapper.UserMapper;
import com.zju.pojo.User;
import com.zju.service.UserService;
import com.zju.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public R<Map<String, Object>> login(String name, String password) {
        User selectOne = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, name));
        if (password.equals(selectOne.getPassword())) {
            //controller层接收数据，生成token，并响应
            Map<String, Object> map = new HashMap<>();
            try {
                Map<String, String> payload = new HashMap<>();
                payload.put("id", selectOne.getId().toString());
                payload.put("name", selectOne.getName());
                //生成JWT令牌
                String token = JWTUtils.getToken(payload);
                map.put("state", true);
                map.put("msg", "认证成功");
                map.put("token", token);//响应token
            } catch (Exception e) {
                map.put("state", "false");
                map.put("msg", e.getMessage());
            }
            return R.success(map);
        }

        return R.error("密码错误");
    }

    @Override
    @Transactional
    public R<String> register(User user) {
        if (user.getName().getBytes().length < 6 || user.getPassword().length() < 6 || !isValidEmail(user.getEmail())) {
            return R.error("注册信息格式错误");
        }
        User one = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, user.getName()));
        if (one != null) {
            return R.error("用户名已注册！");
        }
        one = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getEmail, user.getEmail()));
        if (one != null) {
            return R.error("邮箱已注册！");
        }
        int insert = userMapper.insert(user);
        if(insert == 1){
            return R.success("注册成功！");
        }
        return R.error("注册失败！");
    }

    public static boolean isValidEmail(String email) {
        if ((email != null) && (!email.isEmpty())) {
            return Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email);
        }
        return false;
    }

}
