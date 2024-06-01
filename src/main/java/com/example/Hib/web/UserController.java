package com.example.Hib.web;

import com.example.Hib.domain.User;
import com.example.Hib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users-all")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.put("usersFromDB", users);
        return "users";
    }
}
