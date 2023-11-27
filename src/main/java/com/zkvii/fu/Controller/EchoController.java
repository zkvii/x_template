package com.zkvii.fu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkvii.fu.Dao.UserDao;

@RestController
@RequestMapping("/echo")
public class EchoController {
    @Autowired
    private UserDao userDao;

    @GetMapping("")
    public String echo() {
        return userDao.getAllUsers().toString();
    }
}
