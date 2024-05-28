package me.eiad.warehouse;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.repository.SpringDataDealRepository;
import me.eiad.warehouse.repository.SpringDealRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
public class SpringDataDealRepositoryTest {
    private Deal deal1;
    private Deal deal2;
    @Autowired
    private SpringDataDealRepository springDataDealRepository;
    @Autowired
    private SpringDealRepository springDealRepository;

    @BeforeEach
    void setUp() {
        deal1 = new Deal(1, "JOD", "JOD",
                LocalDate.now(), new BigDecimal(2));
        deal2 = new Deal(2, "JOD", "JOD",
                LocalDate.now(), new BigDecimal(2));
        springDealRepository.deleteAll();
    }


    @Test
    public void after_saving_the_deal_must_not_be_equal_to_null() {
        Deal savedDeal = springDataDealRepository.save(deal1);

        Assertions.assertNotNull(savedDeal);
    }

    @Test
    public void two_deals_must_not_be_equal() {
        Deal savedDeal1 = springDataDealRepository.save(deal1);
        Deal savedDeal2 = springDataDealRepository.save(deal2);

        Assertions.assertNotEquals(savedDeal1, savedDeal2);
    }
}
