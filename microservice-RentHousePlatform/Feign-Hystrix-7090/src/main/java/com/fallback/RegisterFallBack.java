package com.fallback;

import com.Result.Result;
import com.po.User;
import com.service.microserviceRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegisterFallBack implements microserviceRegister {
    @Override
    public Result signRegister(User user) {
        return new Result(400,"服务正忙，请稍后再试");
    }

    @Override
    public Result check(User user) {
        return new Result(400,"服务正忙，请稍后再试");
    }
}
