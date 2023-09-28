package com.example.bank.controller;

import com.example.bank.model.Client;
import com.example.bank.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("all")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable int id) {
        return clientService.findById(id);
    }

    @PostMapping("add")
    public Client add(@RequestBody Client client) {
        return clientService.add(client);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        clientService.delete(id);
    }

    @PutMapping("{id}")
    public Client replace(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.replace(id, client);
    }
}
