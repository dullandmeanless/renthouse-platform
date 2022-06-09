package com.service;


import com.Result.Result;
import com.po.Order;
import com.fallback.OrderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EUREKA-CLIENT-ORDER", fallback = OrderFallBack.class)
public interface microserviceOrder {
    @PostMapping("/order/save")
    Result regisOrder(@RequestBody Order order);

    @GetMapping("/order/getOrder/{id}")
    Result getOrder(@PathVariable("id") Integer id);

    @PostMapping("/order/update")
    Result updateOrder(@RequestBody Order order);

    @DeleteMapping("/order/deleteOrder/{id}")
    Result deleteOrder(@PathVariable("id") Integer id);
    @GetMapping("/user/getOrderByUserId/{id}")
    Result getOrderByUserId(@PathVariable("id") Integer id);
}
