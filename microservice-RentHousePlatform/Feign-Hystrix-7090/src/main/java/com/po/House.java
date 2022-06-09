package com.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class House {
    private Integer hId;
    private String price;
    private String region;
    private String hStatus;
    private String model;
    private String description;
    private Integer recommend;

}
