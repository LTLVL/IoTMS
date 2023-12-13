package com.zju.pojo;

import lombok.Data;

import java.beans.Transient;

@Data
public class Equipment {
    private Long id;
    private String name;
    private String type;
    private String state;
    private String description;
//
//    private Double longitude;
//    private Double latitude;
}
