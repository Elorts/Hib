package com.example.Hib.repository;

import com.example.Hib.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Hib.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
