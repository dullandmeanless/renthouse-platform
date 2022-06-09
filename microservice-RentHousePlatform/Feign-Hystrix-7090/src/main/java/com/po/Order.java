package com.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Integer oId;
    private Integer uId;
    private Integer hId;
    private Integer gross;
    private Integer oStatus;
    private String ordertime;
}

