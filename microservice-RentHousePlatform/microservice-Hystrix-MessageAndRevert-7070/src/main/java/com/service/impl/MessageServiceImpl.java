package com.service.impl;

import com.dao.MessageDao;
import com.po.messages;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao md;
    @Override
    public boolean save(messages ms) {
        return md.insert(ms) > 0;
    }
    @Override
    public boolean update(messages ms) {
        return md.updateById(ms) > 0;
    }

    @Override
    public boolean delete(Integer m_id) {
        return md.deleteById(m_id) > 0;
    }

    @Override
    public messages getById(Integer m_id) {
        return md.selectById(m_id);
    }

    @Override
    public List<messages> getAll() {
        return md.selectList(null);

    }
}
