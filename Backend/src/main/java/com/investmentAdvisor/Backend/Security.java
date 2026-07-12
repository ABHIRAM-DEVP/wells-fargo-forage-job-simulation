package com.investmentAdvisor.Backend;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "my_security")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID securityId;
    private String name;
    private String category;
    private LocalDate purchaseDate;
    private Double purchasePrice;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("securities")
    private Portfolio portfolio;
}
