package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dao.ProductMapper;
import com.po.House;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean save(House user) {
        return productMapper.insert(user) > 0;
    }

    @Override
    public boolean update(House user) {
        return productMapper.updateById(user) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return productMapper.deleteById(id) > 0;
    }

    @Override
    public House getById(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    public List<House> getAll() {
        return productMapper.selectList(null);
    }

    @Override
    public IPage<House> getpage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        productMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<House> getpage(int currentPage, int pageSize, House house) {
        LambdaQueryWrapper<House> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(house.getPrice()), House::getPrice, house.getPrice());
        lqw.like(Strings.isNotEmpty(house.getDescription()), House::getDescription, house.getDescription());
        lqw.like(Strings.isNotEmpty(house.getModel()), House::getModel, house.getModel());
        lqw.like(Strings.isNotEmpty(house.getRecommend()), House::getRecommend, house.getRecommend());
        lqw.like(Strings.isNotEmpty(house.getRegion()), House::getRegion, house.getRegion());

//        lqw.like(Strings.isNotEmpty(book.getName()), User::getName, book.getName());
//        lqw.like(Strings.isNotEmpty(book.getDescription()), User::getDescription, book.getDescription());
        IPage<House> page = new Page(currentPage, pageSize);
        productMapper.selectPage(page, lqw);
        return page;
    }
}
