package com.example.bank.service;

import com.example.bank.exception.NoContentException;
import com.example.bank.model.Client;
import com.example.bank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new NoContentException(id));
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }

    public void delete(int id) {
        Client client = findById(id);
        clientRepository.delete(client);
    }

    public Client replace(int id, Client newClient) {
        Client client = findById(id);
        client.setFio(newClient.getFio());
        client.setAddress(newClient.getAddress());
        client.setAccounts(newClient.getAccounts());
        return clientRepository.save(client);
    }
}
