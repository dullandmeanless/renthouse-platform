package com.controller;

import com.Result.Result;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.po.Order;
import com.service.microserviceOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/feign")
@Slf4j
@DefaultProperties(defaultFallback = "OrderFallBack", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
        //该属性用来没置在滚动时间窗中，断路器熔断的最小请求数。例如，默认该值为20的时候
        //，如果滚动时间窗（默认10秒）内仅收到了19个请求，即使这19个请求都失败了，断路器也不会打开。
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
        @HystrixProperty(name="timeoutInMilliseconds",value = "10"), //配置命令执行的超时时间
        //该属性用来设置当断路器打开之后的休眠时间窗。休眠时间窗结束之后，
        //会将断路器置为“半开”状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为“打开”状态，
        //如果成功就没置为"关闭”状态
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
        //该属性用来没置在滚动时间窗中，表示在滚动时间窗中，在请求数量超过
        //circuitBreaker.requestVolumeThreshold的情况下，如果错误
        //请求数的百分比超过50,就把断路器设置为“打开”状态，否则就设置为“关闭”状态。
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
})
public class OrderController {
    @Resource
    private microserviceOrder mco;

    @GetMapping("/getOrder/{id}")
    public Result getById(@PathVariable Integer id) {
        return mco.getOrder(id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return mco.deleteOrder(id);
    }

    @PostMapping("/orderSave")
    public Result deleteById(@RequestBody Order order) {
        return mco.regisOrder(order);
    }

    @PostMapping("/orderUpdate")
    public Result update(@RequestBody Order order) {
        return mco.updateOrder(order);
    }
    @GetMapping("/getOrderByUserId/{id}")
    public Result getOrderByUserId(@PathVariable("id") Integer id) {
        return mco.getOrderByUserId(id);
    }
}
