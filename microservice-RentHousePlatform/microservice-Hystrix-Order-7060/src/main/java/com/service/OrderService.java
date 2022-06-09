package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.po.Order;

import java.util.List;

public interface OrderService {
    boolean save(Order order);
    boolean update(Order order);
    boolean delete(Integer id);
    Order getById(Integer id);
    List<Order> getAll();
    IPage<Order> getpage(int currentPage, int pageSize);
    IPage<Order> getpage(int currentPage, int pageSize, Order order);
}
