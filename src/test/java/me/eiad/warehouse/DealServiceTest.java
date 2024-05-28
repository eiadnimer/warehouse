package me.eiad.warehouse;

import me.eiad.warehouse.api.DealDTO;
import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.core.DealsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DealServiceTest {
    private final MockDealRepository dealRepository = new MockDealRepository();
    private final DealsService dealsService = new DealsService(dealRepository);

    @Test
    public void make_sure_the_deal_was_saved_correctly() {
        dealsService.saveDeal(new DealDTO(1, "JOD", "JOD", LocalDate.now(), new BigDecimal(2)));
        dealsService.saveDeal(new DealDTO(2, "JOD", "JOD", LocalDate.now(), new BigDecimal(2)));

        Assertions.assertEquals(2, dealRepository.deals.size());
    }

    @Test
    public void make_sure_that_the_deal_after_saving_must_have_the_same_UniqueID() {
        Deal savedDeal = dealsService.saveDeal(new DealDTO(1, "JOD", "JOD",
                LocalDate.now(), new BigDecimal(2)));

        Assertions.assertEquals(savedDeal.uniqueId(), 1);
    }
}
