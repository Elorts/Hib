package com.example.Hib.service;

import com.example.Hib.domain.Account;
import com.example.Hib.domain.User;
import com.example.Hib.repository.AccountRepository;
import com.example.Hib.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AccountRepository accountRepo;

    public List<User> findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    public List<User> findByUserNameAndName(String userName, String name) {
        return userRepo.findByUserNameAndName(userName, name);
    }

    public List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2) {
        return userRepo.findByCreatedDateBetween(date1, date2);
    }

    public User findExactlyOneUserByUserName(String userName) {
        List <User> users = userRepo.findExactlyOneUserByUserName(userName);
        if (users.size() > 0)
            return users.get(0);
        else
            return new User();
    }

//    public List<User> findAll () {
//        return userRepo.findAll();
//    }

    public Set<User> findAll () {
        return userRepo.findAllUsersWithAccountsAndAddresses();
    }



    public User findOne(Long userId){
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.orElse(new User());
    }

    public User saveUser(User user) {
        if (user.getUserId() == null) {
            Account checking = new Account();
            checking.setAccountName("Checking Account");
            checking.getUsers().add(user);

            Account savings = new Account();
            savings.setAccountName("SA");
            savings.getUsers().add(user);

            user.getAccounts().add(checking);
            user.getAccounts().add(savings);

            accountRepo.save(checking);
            accountRepo.save(savings);
        }
        return userRepo.save(user);
    }

    public void delete(Long userId) {
        userRepo.deleteById(userId);
    }
}
