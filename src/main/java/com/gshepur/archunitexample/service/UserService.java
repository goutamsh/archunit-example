package com.gshepur.archunitexample.service;

import com.gshepur.archunitexample.dao.UserDao;
import com.gshepur.archunitexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
