package com.tao.pojo;

import lombok.Data;

@Data
public class Equipment {
    private Integer id;
    private String name;
    private String type;
    private String state;
    private String description;
    private Double longitude;
    private Double latitude;
}
