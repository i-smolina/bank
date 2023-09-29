package com.example.bank.repository;

import com.example.bank.model.Account;
import com.example.bank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByClient(Client client);
}
