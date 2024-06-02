package com.example.Hib.service;

import com.example.Hib.domain.User;
import com.example.Hib.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll () {
        return userRepo.findAll();
    }

    public User findOne(Long userId){
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.orElse(new User());
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
