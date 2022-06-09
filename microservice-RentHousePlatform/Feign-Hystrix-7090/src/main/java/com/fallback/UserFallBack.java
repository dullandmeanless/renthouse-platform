package com.fallback;

import com.Result.Result;
import com.po.User;
import com.service.microserviceUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFallBack implements microserviceUser {
    @Override
    public Result regisUser(User user) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result getUser(Integer id) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result updateUser(User user) {
        return new Result(400, "服务正忙，请稍后再试");
    }

}
