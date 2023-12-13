package com.zju.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zju.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
