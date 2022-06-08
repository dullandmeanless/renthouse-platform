package com.controller;

import com.domain.Result;
import com.mapper.MenuMapper;
import com.mapper.UserMapper;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('can:hello')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/getAll")
    @PreAuthorize("hasAuthority('can:getAll')")
    public Result getAll(){
        return new Result(200,"getAll功能",userMapper.selectList(null));
    }
    @RequestMapping("/test")
    public Result test(){
        return new Result(200,"test功能",null);
    }
//    public String getAll(){
//        return "getAll";
//    }
}
