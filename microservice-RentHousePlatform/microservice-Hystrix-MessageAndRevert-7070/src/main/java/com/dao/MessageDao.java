package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.po.messages;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MessageDao extends BaseMapper<messages> {
}
