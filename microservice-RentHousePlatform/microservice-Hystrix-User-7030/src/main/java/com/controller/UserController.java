package com.controller;

import com.Result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.po.User;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
@Api(tags= {"UserController"},description = "User控制类")
public class UserController {
    @Autowired
    private UserService us;

    @ApiOperation("获取全部用户信息")
    @GetMapping("/getAll")
    public Result getAll() {
        return new Result(200, "操作成功", us.getAll());
    }

    @ApiOperation("分页查询")
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, User user) {
        IPage<User> page = us.getpage(currentPage, pageSize, user);
        if (currentPage > page.getPages()) {
            page = us.getpage((int) page.getPages(), pageSize, user);
        }
        return new Result(200, "操作成功", page);
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

    @ApiOperation("根据id删除用户")
    @ApiImplicitParam(value = "用户id", name = "id")
    @DeleteMapping("/deleteUser/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if (Objects.isNull(us.delete(id))) {
            return new Result(400, "删除用户失败");
        }
        return new Result(200, "删除用户成功", us.delete(id));
    }

    @ApiOperation("添加用户")
    @PostMapping("/regisUser")
    public Result deleteById(@RequestBody User user) {
        if (Objects.isNull(user)) {
            return new Result(400, "添加用户失败");
        }
        return new Result(200, "添加用户成功", us.save(user));
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/updateUser")
    public Result update(@RequestBody User user) {
        return new Result(200, "修改用户成功", us.update(user));
    }
}
