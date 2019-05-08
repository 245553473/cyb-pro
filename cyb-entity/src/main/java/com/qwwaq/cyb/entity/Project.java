package com.qwwaq.cyb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    private static final long serialVersionUID = 8820678050985046949L;
    private Integer id;
    private String name;
    private String introduction;
    private String detail;
    private String imageAddress;
    private Integer creator;
}