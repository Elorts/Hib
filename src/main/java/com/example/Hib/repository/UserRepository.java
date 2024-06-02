package com.example.Hib.repository;

import com.example.Hib.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Hib.domain.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from users where username = :name
    List<User> findByUserName(String userName);

    // select * from users where name = :name
    List<User> findByName(String name);

    // select * from users where userName = :userName and name = :name
    List<User> findByUserNameAndName(String userName, String name);

    List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2);
}
