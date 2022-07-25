package com.pfms.dao;

import com.pfms.entity.User;

import java.util.Map;

public interface UserDao {
    User findByname(String name);

}
