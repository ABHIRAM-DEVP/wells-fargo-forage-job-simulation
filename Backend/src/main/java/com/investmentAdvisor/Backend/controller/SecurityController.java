package com.investmentAdvisor.Backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investmentAdvisor.Backend.Security;
import com.investmentAdvisor.Backend.service.SecurityService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/securities")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public ResponseEntity<List<Security>> getAllSecurities() {
        return ResponseEntity.ok(securityService.getAllSecurities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable UUID id) {
        return securityService.getSecurityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Security> createSecurity(@RequestBody Security security) {
        return ResponseEntity.ok(securityService.saveOrUpdateSecurity(security));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable UUID id, @RequestBody Security security) {
        security.setSecurityId(id);
        return ResponseEntity.ok(securityService.saveOrUpdateSecurity(security));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecurity(@PathVariable UUID id) {
        securityService.deleteSecurity(id);
        return ResponseEntity.noContent().build();
    }
}
