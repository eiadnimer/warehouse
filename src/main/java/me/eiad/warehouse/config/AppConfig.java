package me.eiad.warehouse.config;

import me.eiad.warehouse.core.DealsService;
import me.eiad.warehouse.repository.SpringDataDealRepository;
import me.eiad.warehouse.repository.SpringDealRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.eiad.warehouse.core.DealMapper;
import me.eiad.warehouse.core.DealRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    public DealMapper dealMapper() {
        return new DealMapper();
    }

    @Bean
    public DealsService dealsService(DealRepository dealRepository) {
        return new DealsService(dealRepository);
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public DealRepository dealRepository(SpringDealRepository springDealRepository, DealMapper dealMapper) {
        return new SpringDataDealRepository(springDealRepository, dealMapper);
    }
}
