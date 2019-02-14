package com.gshepur.archunitexample.dao;

import com.gshepur.archunitexample.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public User getUserById(int id) {
        return new User(1, "Ram");
    }
}
