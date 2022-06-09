package com.service;

import com.po.revert;

import java.util.List;

public interface RevertService {
    boolean save(revert rv);
    boolean update(revert rv);
    boolean delete(Integer r_id);
    revert getById(Integer r_id);
    List<revert> getAll();
}
