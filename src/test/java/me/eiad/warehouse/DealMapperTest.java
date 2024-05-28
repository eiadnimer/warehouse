package me.eiad.warehouse;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.api.DealDTO;
import me.eiad.warehouse.repository.DealEntity;
import me.eiad.warehouse.core.DealMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DealMapperTest {
    private final Deal deal = new Deal(1, "JOD", "JOD",
            LocalDate.now(), new BigDecimal(2));
    private final DealDTO dealDTO = new DealDTO(1, "JOD", "JOD",
            LocalDate.now(), new BigDecimal(2));
    private final DealMapper dealMapper = new DealMapper();

    @Test
    public void must_convert_to_entity_correctly() {
        DealEntity dealEntity = dealMapper.toEntity(deal);

        Assertions.assertEquals(dealEntity.getUniqueId(), deal.uniqueId());
        Assertions.assertEquals(dealEntity.getDealTimestamp(), deal.dealTimestamp());
        Assertions.assertEquals(dealEntity.getFromCurrencyIsoCode(), deal.fromCurrencyIsoCode());
        Assertions.assertEquals(dealEntity.getToCurrencyIsoCode(), deal.toCurrencyIsoCode());
        Assertions.assertEquals(dealEntity.getAmount(), deal.amount());
    }

    @Test
    public void must_convert_from_entity_correctly() {
        DealEntity dealEntity = dealMapper.toEntity(deal);
        Deal convertedDeal = dealMapper.toModel(dealEntity);

        Assertions.assertEquals(convertedDeal.uniqueId(), dealEntity.getUniqueId());
        Assertions.assertEquals(convertedDeal.fromCurrencyIsoCode(), dealEntity.getFromCurrencyIsoCode());
        Assertions.assertEquals(convertedDeal.toCurrencyIsoCode(), dealEntity.getToCurrencyIsoCode());
        Assertions.assertEquals(convertedDeal.dealTimestamp(), dealEntity.getDealTimestamp());
        Assertions.assertEquals(convertedDeal.amount(), dealEntity.getAmount());
    }

    @Test
    public void must_convert_from_DTO_correctly() {
        Deal convertedDeal = dealMapper.toModel(dealDTO);

        Assertions.assertEquals(deal.uniqueId(), convertedDeal.uniqueId());
        Assertions.assertEquals(deal.fromCurrencyIsoCode(), convertedDeal.fromCurrencyIsoCode());
        Assertions.assertEquals(deal.toCurrencyIsoCode(), convertedDeal.toCurrencyIsoCode());
        Assertions.assertEquals(deal.dealTimestamp(), convertedDeal.dealTimestamp());
        Assertions.assertEquals(deal.amount(), convertedDeal.amount());
    }
}
