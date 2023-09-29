package com.example.bank.service;

import com.example.bank.exception.NoContentException;
import com.example.bank.model.Account;
import com.example.bank.model.Client;
import com.example.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final ClientService clientService;

    public Account findById(int id) {
        return accountRepository.findById(id).orElseThrow(() -> new NoContentException("Not found account id = " + id));
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public List<Account> findByClient(int clientId) {
        Client client = clientService.findById(clientId);
        return accountRepository.findByClient(client);
    }

    public Account add(Account account) {
        return accountRepository.save(account);
    }

    public Account replace(int id, Account newAccount) {
        Account account = findById(id);
        account.setName(newAccount.getName());
        account.setBalance(account.getBalance());
        account.setClient(newAccount.getClient());
        return accountRepository.save(account);
    }

    public void delete(int id) {
        Account account = findById(id);
        accountRepository.delete(account);
    }

}
