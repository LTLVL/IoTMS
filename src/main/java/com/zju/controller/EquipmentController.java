package com.zju.controller;

import com.zju.common.R;
import com.zju.pojo.Equipment;
import com.zju.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equip")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public R<List<Equipment>> list(){
        return R.success(equipmentService.list());
    }




}
