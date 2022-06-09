package com.service.impl;

import com.dao.RevertDao;
import com.po.revert;
import com.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevertServiceImpl implements RevertService {
    @Autowired
    private RevertDao revertDao;

    @Override
    public boolean save(revert rv) {
        return revertDao.insert(rv) > 0;
    }

    @Override
    public boolean update(revert rv) {
        return revertDao.updateById(rv) > 0;
    }
    @Override
    public boolean delete(Integer r_id) {
        return revertDao.deleteById(r_id) > 0;
    }
    @Override
    public revert getById(Integer r_id) {
        return revertDao.selectById(r_id);
    }

    @Override
    public List<revert> getAll() {
        return revertDao.selectList(null);
    }
}
