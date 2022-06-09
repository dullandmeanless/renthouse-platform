package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.po.User;

import java.util.List;

public interface UserService {
    boolean save(User user);
    boolean update(User user);
    boolean delete(Integer id);
    User getById(Integer id);
    List<User> getAll();
    IPage<User> getpage(int currentPage, int pageSize);
    IPage<User> getpage(int currentPage, int pageSize, User user);
//    List<User> like(String column,String value);
}
