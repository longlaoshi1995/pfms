package com.pfms.service.imp;

import com.pfms.dao.UserDao;
import com.pfms.entity.User;
import com.pfms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServieImpl implements IUserService {

    @Autowired
    UserDao userDao;

     public   User findByname(String name){
         return userDao.findByname(name);
     }
}
