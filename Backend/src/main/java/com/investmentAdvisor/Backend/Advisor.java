package com.investmentAdvisor.Backend;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "my_advisor")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID advisorId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    @OneToMany(mappedBy = "advisor",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
               
    private List<Client> clients;
}
