package com.example.Hib.domain;

import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(length = 100)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    private Long accountId;
    private String accountName;

}
