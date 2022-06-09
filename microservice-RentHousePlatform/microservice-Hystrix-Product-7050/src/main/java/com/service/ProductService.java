package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.po.House;

import java.util.List;

public interface ProductService {
    boolean save(House house);
    boolean update(House house);
    boolean delete(Integer id);
    House getById(Integer id);
    List<House> getAll();
    IPage<House> getpage(int currentPage, int pageSize);
    IPage<House> getpage(int currentPage, int pageSize, House house);
}
