package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.po.House;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<House> {
}
