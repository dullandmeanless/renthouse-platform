package com.service;

import com.Result.Result;
import com.po.User;
import com.fallback.UserFallBack;;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "EUREKA-CLIENT-USER", fallback = UserFallBack.class)
public interface microserviceUser {
    @RequestMapping("/user/save")
    Result regisUser(@RequestBody User user);

    @GetMapping("/user/getUser/{id}")
    Result getUser(@PathVariable("id") Integer id);

    @RequestMapping("/user/updateUser")
    Result updateUser(@RequestBody User user);

}
