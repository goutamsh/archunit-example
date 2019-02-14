package com.gshepur.archunitexample.api;

import com.gshepur.archunitexample.model.User;
import com.gshepur.archunitexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping
    public User getUser(int id){
        return userService.getUserById (id);
    }
}
