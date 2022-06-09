package com.controller;

import com.Result.Result;
import com.po.User;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/register")
@Api(tags= {"RegisterController"},description = "Register控制类")
public class RegisterController {
    @Autowired
    private UserService us;

    @GetMapping
    public Result getAll() {
        return new Result(200, "操作成功", us.getAll());
    }

    @ApiOperation("根据id获取用户信息")
    @ApiImplicitParam(value = "用户id", name = "id")
    @GetMapping("/getUser/{id}")
    public Result getById(@PathVariable Integer id) {
        if (Objects.isNull(us.getById(id))) {
            return new Result(400, "查询用户失败");
        }
        return new Result(200, "查询用户成功", us.getById(id));
    }
    @ApiOperation("添加用户")
    @PostMapping("/regis")
    public Result deleteById(@RequestBody User user) {
        if (Objects.isNull(user)) {
            return new Result(400, "添加用户失败");
        }
        return new Result(200, "添加用户成功", us.save(user));
    }
    @ApiOperation("检查用户是否已经注册")
    @PostMapping("/checkUser")
    public Result check(@RequestBody User user) {
        List<User> list = us.getAll();
        for (User temp : list) {
            if (temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword()))
                return new Result(400, "用户已存在");
        }
        return new Result(200, "用户注册成功", us.save(user));
    }
    @ApiOperation("根据id获取删除信息")
    @ApiImplicitParam(value = "用户id", name = "id")
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if (Objects.isNull(us.delete(id))) {
            return new Result(400, "删除用户失败");
        }
        return new Result(200, "删除用户成功", us.delete(id));
    }


}
