package com.pfms.service;

import com.pfms.entity.User;

public interface IUserService {
    public User findByname(String name);
}
