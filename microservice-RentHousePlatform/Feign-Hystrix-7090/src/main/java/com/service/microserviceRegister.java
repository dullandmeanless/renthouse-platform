package com.service;

import com.Result.Result;
import com.po.User;
import com.fallback.RegisterFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EUREKA-CLIENT-REGISTER", fallback = RegisterFallBack.class)
public interface microserviceRegister {
    @PostMapping("/register/regis")
    Result signRegister(@RequestBody User user);

    @GetMapping("/register/checkUser")
    Result check(@RequestBody User user);
//    @GetMapping(value = "/register/getRegister/{id}")
//    Result getRegister(@PathVariable("id") Integer id);
}
