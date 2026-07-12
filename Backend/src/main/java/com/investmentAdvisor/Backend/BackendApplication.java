package com.investmentAdvisor.Backend;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.investmentAdvisor.Backend.repository.AdvisorRepository;
import com.investmentAdvisor.Backend.repository.ClientRepository;
import com.investmentAdvisor.Backend.repository.PortfolioRepository;
import com.investmentAdvisor.Backend.repository.SecurityRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedData(
			AdvisorRepository advisorRepo,
			ClientRepository clientRepo,
			PortfolioRepository portfolioRepo,
			SecurityRepository securityRepo) {
		return args -> {
			if (advisorRepo.count() == 0) {
				// Create default advisor
				Advisor advisor = Advisor.builder()
						.firstName("John")
						.lastName("Miller")
						.address("100 Wells Fargo Way, Charlotte, NC")
						.email("john.miller@wellsfargo.com")
						.build();
				advisor = advisorRepo.save(advisor);

				// Create client 1
				Client client1 = Client.builder()
						.firstName("Alice")
						.lastName("Smith")
						.address("123 Main St, New York, NY")
						.email("alice.smith@example.com")
						.advisor(advisor)
						.build();
				client1 = clientRepo.save(client1);

				Portfolio portfolio1 = Portfolio.builder()
						.client(client1)
						.build();
				portfolio1 = portfolioRepo.save(portfolio1);

				Security sec1 = Security.builder()
						.name("Wells Fargo & Co (WFC)")
						.category("Equity")
						.purchaseDate(LocalDate.now().minusMonths(3))
						.purchasePrice(55.20)
						.quantity(100)
						.portfolio(portfolio1)
						.build();
				Security sec2 = Security.builder()
						.name("Apple Inc. (AAPL)")
						.category("Equity")
						.purchaseDate(LocalDate.now().minusMonths(6))
						.purchasePrice(175.50)
						.quantity(50)
						.portfolio(portfolio1)
						.build();
				securityRepo.save(sec1);
				securityRepo.save(sec2);

				// Create client 2
				Client client2 = Client.builder()
						.firstName("Bob")
						.lastName("Jones")
						.address("456 Broad St, Charlotte, NC")
						.email("bob.jones@example.com")
						.advisor(advisor)
						.build();
				client2 = clientRepo.save(client2);

				Portfolio portfolio2 = Portfolio.builder()
						.client(client2)
						.build();
				portfolio2 = portfolioRepo.save(portfolio2);

				Security sec3 = Security.builder()
						.name("Treasury Bond 10Y")
						.category("Fixed Income")
						.purchaseDate(LocalDate.now().minusYears(1))
						.purchasePrice(980.00)
						.quantity(10)
						.portfolio(portfolio2)
						.build();
				securityRepo.save(sec3);

				System.out.println("--- DATABASE SEEDED WITH ADVISORS, CLIENTS AND SECURITIES ---");
			}
		};
	}
}
