package com.fallback;

import com.Result.Result;
import com.po.House;
import com.service.microserviceProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductFallBack implements microserviceProduct {
    @Override
    public Result regisHouse(House house) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result getHouse(Integer id) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result updateHouse(House house) {
        return new Result(400, "服务正忙，请稍后再试");
    }

    @Override
    public Result deleteHouse(Integer id) {
        return new Result(400, "服务正忙，请稍后再试");
    }
}
