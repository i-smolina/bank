package com.example.bank.controller;

import com.example.bank.model.Account;
import com.example.bank.model.Client;
import com.example.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("{id}")
    public Account findById(@PathVariable int id) {
        return accountService.findById(id);
    }

    @GetMapping("all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("client/{id}")
    public List<Account> findByClient(@PathVariable int id) {
        return accountService.findByClient(id);
    }

    @PostMapping("add")
    public Account add(@RequestBody Account account) {
        return accountService.add(account);
    }

    @PutMapping("replace/{id}")
    public Account replace(@RequestBody Account account, @PathVariable int id) {
        return accountService.replace(id, account);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        accountService.delete(id);
    }
}
