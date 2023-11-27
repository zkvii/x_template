package com.zkvii.fu.Controller;

import com.zkvii.fu.Dao.EchoDao;
import com.zkvii.fu.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EchoController {
     @Autowired
     private UserDao userDao;

     @Autowired
     private EchoDao echoDao;

    // @GetMapping("")
    // public String echo() {
    //     return userDao.getAllUsers().toString();
    // }
    @GetMapping("/echo")
    public String hello(Model model) {
        var ret=userDao.getUserPrivilegeLevel("lk").toString();
        var echo=echoDao.getTableInfo("user");
        model.addAttribute("message", ret);
        model.addAttribute("echo", echo);
        return "echo"; // This corresponds to the template file name without the extension
    }
}
