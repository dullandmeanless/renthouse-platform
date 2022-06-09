package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dao.UserMapper;
import com.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectList(null);
    }

    @Override
    public IPage<User> getpage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<User> getpage(int currentPage, int pageSize, User book) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Strings.isNotEmpty(book.getType()), User::getType, book.getType());
//        lqw.like(Strings.isNotEmpty(book.getName()), User::getName, book.getName());
//        lqw.like(Strings.isNotEmpty(book.getDescription()), User::getDescription, book.getDescription());
        IPage<User> page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, null);
        return page;
    }
}
