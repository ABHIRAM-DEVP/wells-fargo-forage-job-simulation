package com.investmentAdvisor.Backend.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.investmentAdvisor.Backend.Advisor;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, UUID> {
}
