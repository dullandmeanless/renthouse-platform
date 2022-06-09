package com.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("renthouse.house")
public class House {
    @TableId(type = IdType.AUTO)
    private Integer hId;
    private String price;
    private String region;
    @TableField("h_status")
    private String hStatus;
    private String model;
    private String description;
    private String recommend;
}
