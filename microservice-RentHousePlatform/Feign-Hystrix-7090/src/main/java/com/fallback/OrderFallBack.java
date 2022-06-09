package com.fallback;

import com.Result.Result;
import com.po.Order;
import com.service.microserviceOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderFallBack implements microserviceOrder {
    @Override
    public Result regisOrder(Order order) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result getOrder(Integer id) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result updateOrder(Order order) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result deleteOrder(Integer id) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result getOrderByUserId(Integer id) {
        return new Result(400, "服务正忙，请稍后再试");
    }

}
