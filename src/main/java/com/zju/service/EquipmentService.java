package com.zju.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zju.common.R;
import com.zju.mapper.EquipmentMapper;
import com.zju.pojo.Equipment;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EquipmentService extends IService<Equipment> {

    R<List<Equipment>> listAll(String name);

    R<List<Equipment>> saveEquip(HttpServletRequest request, Equipment equipment);

    R<String> updateEquip(Equipment equipment);
}
