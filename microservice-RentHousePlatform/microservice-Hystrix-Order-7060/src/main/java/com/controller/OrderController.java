package com.controller;

import com.Result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.po.Order;
import com.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/order")
@Api(tags = {"OrderController"}, description = "Order控制类")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("查询全部订单信息")
    @GetMapping("/getAll")
    public Result getAll() {
        return new Result(200, "操作成功", orderService.getAll());
    }

    @ApiOperation("分页查询")
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Order order) {
        IPage<Order> page = orderService.getpage(currentPage, pageSize, order);
        if (currentPage > page.getPages()) {
            page = orderService.getpage((int) page.getPages(), pageSize, order);
        }
        return new Result(200, "操作成功", page);
    }

    @ApiOperation("根据id获取订单信息")
    @ApiImplicitParam(value = "订单id", name = "id")
    @GetMapping("/getOrder/{id}")
    public Result getById(@PathVariable Integer id) {
        if (Objects.isNull(orderService.getById(id))) {
            return new Result(400, "查询订单失败");
        }
        return new Result(200, "查询订单成功", orderService.getById(id));
    }

    @ApiOperation("根据id获取删除信息")
    @ApiImplicitParam(value = "订单id", name = "id")
    @DeleteMapping("/deleteOrder/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if (Objects.isNull(orderService.delete(id))) {
            return new Result(400, "删除订单失败");
        }
        return new Result(200, "删除订单成功", orderService.delete(id));
    }

    @ApiOperation("添加订单信息")
    @PostMapping("/saveOrder")
    public Result save(@RequestBody Order order) {
        if (Objects.isNull(order)) {
            return new Result(400, "添加订单失败");
        }
        return new Result(200, "添加订单成功", orderService.save(order));
    }

    @ApiOperation("更新订单信息")
    @PutMapping("/updateOrder")
    public Result update(@RequestBody Order order) {
        return new Result(200, "修改订单信息成功", orderService.update(order));
    }

}
