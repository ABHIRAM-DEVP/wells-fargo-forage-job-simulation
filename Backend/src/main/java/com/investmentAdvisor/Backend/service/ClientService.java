package com.investmentAdvisor.Backend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentAdvisor.Backend.Client;
import com.investmentAdvisor.Backend.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(UUID clientId) {
        clientRepository.deleteById(clientId);
    }
}
