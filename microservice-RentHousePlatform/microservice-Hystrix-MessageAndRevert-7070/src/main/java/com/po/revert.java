package com.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@TableName(value = "test.revert")
public class revert {
    @TableId(type = IdType.AUTO)
    private Integer rId;
    private Integer mId;
    private String administratorId;
    private String rContext;
    @TableField("r_updatetime")
    private String rUpdatetime;
}
