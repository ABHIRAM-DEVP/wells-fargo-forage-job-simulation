package com.investmentAdvisor.Backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investmentAdvisor.Backend.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, UUID> {
}
