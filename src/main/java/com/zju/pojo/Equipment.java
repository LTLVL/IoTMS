package com.zju.pojo;

import lombok.Data;

import java.beans.Transient;
import java.time.LocalDate;

@Data
public class Equipment {
    private Long id;
    private String name;
    private String type;
    private String state;
    private String description;
    private String creator;
    private LocalDate createTime;
    private LocalDate updateTime;
//
//    private Double longitude;
//    private Double latitude;
}
