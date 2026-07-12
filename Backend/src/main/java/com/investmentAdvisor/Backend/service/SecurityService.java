package com.investmentAdvisor.Backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentAdvisor.Backend.Security;
import com.investmentAdvisor.Backend.repository.SecurityRepository;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;

    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    public Optional<Security> getSecurityById(UUID securityId) {
        return securityRepository.findById(securityId);
    }

    public Security saveOrUpdateSecurity(Security security) {
        return securityRepository.save(security);
    }

    public void deleteSecurity(UUID securityId) {
        securityRepository.deleteById(securityId);
    }
}
