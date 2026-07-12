package com.investmentAdvisor.Backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentAdvisor.Backend.Client;
import com.investmentAdvisor.Backend.Portfolio;
import com.investmentAdvisor.Backend.repository.ClientRepository;
import com.investmentAdvisor.Backend.repository.PortfolioRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(UUID clientId) {
        return clientRepository.findById(clientId);
    }

    public Client saveOrUpdateClient(Client client) {
        boolean isNew = (client.getClientId() == null);
        Client saved = clientRepository.save(client);
        if (isNew) {
            Portfolio portfolio = Portfolio.builder()
                    .client(saved)
                    .build();
            portfolioRepository.save(portfolio);
        }
        return saved;
    }

    public void deleteClient(UUID clientId) {
        clientRepository.deleteById(clientId);
    }
}
