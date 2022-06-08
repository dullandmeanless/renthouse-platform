package com.service;

import com.domain.Result;
import com.domain.User;

public interface LoginService {
    Result login(User user);
    Result logout();
}
