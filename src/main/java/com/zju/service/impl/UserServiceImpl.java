package com.zju.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.mapper.EquipmentMapper;
import com.zju.pojo.Equipment;
import com.zju.service.EquipmentService;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {
}
