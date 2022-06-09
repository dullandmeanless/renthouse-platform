package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.po.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
