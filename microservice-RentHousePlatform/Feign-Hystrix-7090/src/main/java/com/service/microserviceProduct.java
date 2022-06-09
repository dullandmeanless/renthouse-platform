package com.service;

import com.Result.Result;
import com.po.House;
import com.fallback.ProductFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EUREKA-CLIENT-PRODUCT", fallback = ProductFallBack.class)
public interface microserviceProduct {
    @PostMapping("/product/save")
    Result regisHouse(@RequestBody House house);

    @GetMapping("/product/getProduct/{id}")
    Result getHouse(@PathVariable("id") Integer id);

    @PostMapping("/product/update")
    Result updateHouse(@RequestBody House house);

    @DeleteMapping("/product/deleteProduct/{id}")
    Result deleteHouse(@PathVariable("id") Integer id);

}
