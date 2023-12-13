package com.zju.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.common.R;
import com.zju.mapper.EquipmentMapper;
import com.zju.pojo.Equipment;
import com.zju.service.EquipmentService;
import com.zju.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {

    @Override
    public R<List<Equipment>> listAll(String name) {
        return R.success(this.list(new LambdaQueryWrapper<Equipment>().eq(Equipment::getCreator, name)));
    }

    @Transactional
    @Override
    public R<List<Equipment>> saveEquip(HttpServletRequest request, Equipment equipment) {
        String token = request.getHeader("token");
        DecodedJWT jwt = JWTUtils.getToken(token);
        String userId = jwt.getClaim("id").asString();
        String username = jwt.getClaim("name").asString();
        equipment.setCreator(username);
        equipment.setCreateTime(LocalDate.now());
        equipment.setUpdateTime(LocalDate.now());
        this.save(equipment);

        return this.listAll(username);
    }

    @Override
    public R<String> updateEquip(Equipment equipment) {
        this.updateById(equipment);
        return R.success("更新成功！");
    }
}
