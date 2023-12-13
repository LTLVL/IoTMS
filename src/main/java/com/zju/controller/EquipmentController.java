package com.zju.controller;

import com.zju.common.R;
import com.zju.pojo.Equipment;
import com.zju.service.EquipmentService;
import com.zju.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equip")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("{name}")
    public R<List<Equipment>> listAll(@PathVariable String name){
        return equipmentService.listAll(name);
    }

    @PostMapping()
    public R<List<Equipment>> saveEquip(HttpServletRequest request, @RequestBody Equipment equipment){
        return equipmentService.saveEquip(request, equipment);
    }

    @PutMapping()
    public R<String> updateEquip(@RequestBody Equipment equipment){
        return equipmentService.updateEquip(equipment);
    }


}
