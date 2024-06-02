package com.example.Hib.repository;

import com.example.Hib.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
