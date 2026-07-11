package com.investmentAdvisor.Backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investmentAdvisor.Backend.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
}
