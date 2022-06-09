package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dao.OrderMapper;
import com.po.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean save(Order order) {
        return orderMapper.insert(order) > 0;
    }

    @Override
    public boolean update(Order order) {
        return orderMapper.updateById(order) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return orderMapper.deleteById(id) > 0;
    }

    @Override
    public Order getById(Integer id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderMapper.selectList(null);
    }

    @Override
    public IPage<Order> getpage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        orderMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Order> getpage(int currentPage, int pageSize, Order order) {
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<>();
        lqw.like(Objects.isNull(order.getUId()), Order::getUId, order.getUId());
        lqw.like(Objects.isNull(order.getHId()), Order::getHId, order.getHId());
        lqw.like(Objects.isNull(order.getGross()), Order::getGross, order.getGross());
        IPage<Order> page = new Page(currentPage, pageSize);
        orderMapper.selectPage(page, null);
        return page;
    }
}
