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
@TableName("renthouse.order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer oId;
    private Integer uId;
    private Integer hId;
    private Integer gross;
    private Integer oStatus;
    @TableField("ordertime")
    private String ordertime;
}
