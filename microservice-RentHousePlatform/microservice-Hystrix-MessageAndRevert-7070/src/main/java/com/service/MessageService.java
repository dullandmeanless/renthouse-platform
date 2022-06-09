package com.service;

import com.po.messages;

import java.util.List;

public interface MessageService {
    boolean save(messages ms);
    boolean update(messages ms);
    boolean delete(Integer m_id);
    messages getById(Integer m_id);
    List<messages> getAll();
}
