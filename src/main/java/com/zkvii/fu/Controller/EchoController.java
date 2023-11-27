package com.zkvii.fu.Controller;

import com.zkvii.fu.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EchoController {
     @Autowired
     private UserDao userDao;

    // @GetMapping("")
    // public String echo() {
    //     return userDao.getAllUsers().toString();
    // }
    @GetMapping("/echo")
    public String hello(Model model) {
        var ret=userDao.getUserPrivilegeLevel("lk").toString();
        model.addAttribute("message", ret);
        return "echo"; // This corresponds to the template file name without the extension
    }
}
