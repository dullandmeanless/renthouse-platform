package com.Result;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("返回类型")
public class Result<T>  {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code,String message){
        this(code,message,null);
    }
}