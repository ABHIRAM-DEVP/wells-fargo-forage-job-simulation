package com.investmentAdvisor.Backend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentAdvisor.Backend.Security;
import com.investmentAdvisor.Backend.repository.SecurityRepository;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;

    public Security saveOrUpdateSecurity(Security security) {
        return securityRepository.save(security);
    }

    public void deleteSecurity(UUID securityId) {
        securityRepository.deleteById(securityId);
    }
}
