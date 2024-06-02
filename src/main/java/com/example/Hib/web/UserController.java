package com.example.Hib.web;

import com.example.Hib.domain.User;
import com.example.Hib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getCreateUser (ModelMap model) {
        model.put("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postCreateUser (User user) {
        System.out.println(user);
        userService.createUser(user);
        return "redirect:/register";  // after postmaping return redirect!
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.put("users", users);
        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getUser(ModelMap model, @PathVariable Long userId) {
        User user = userService.findOne(userId);
        model.put("users", Arrays.asList(user));
        return "users";
    }
}
