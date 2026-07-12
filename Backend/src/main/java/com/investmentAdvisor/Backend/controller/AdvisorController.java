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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.investmentAdvisor.Backend.Advisor;
import com.investmentAdvisor.Backend.repository.AdvisorRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/advisors")
public class AdvisorController {

    @Autowired
    private AdvisorRepository advisorRepository;

    @GetMapping
    public ResponseEntity<List<Advisor>> getAllAdvisors() {
        return ResponseEntity.ok(advisorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Advisor> createAdvisor(@RequestBody Advisor advisor) {
        return ResponseEntity.ok(advisorRepository.save(advisor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable UUID id) {
        advisorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
