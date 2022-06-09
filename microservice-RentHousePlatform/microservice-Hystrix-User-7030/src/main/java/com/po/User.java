package com.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("renthouse.user")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class User {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @TableField("password")
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("用户性别")
    private String sex;
    @ApiModelProperty("用户所属地区")
    private String region;
    @ApiModelProperty("用户的联系方式")
    private String phone;
}
