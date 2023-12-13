package com.zju.pojo;

import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class User {
    private Integer id;
    @Size(max = 20, min = 6)
    private String name;
    private String password;
    private String email;
}
