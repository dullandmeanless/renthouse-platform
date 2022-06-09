package com.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName(value = "test.messages")
public class messages {
    @TableId(type = IdType.AUTO)
    private Integer mId;
    @TableField(value = "userName")
    private String userName;
    private String context;
    private String updatetime;
}
