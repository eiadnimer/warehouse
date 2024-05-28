package me.eiad.warehouse.core.validations;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.FieldMustNotBeEmpty;

@Slf4j
public class ToCurrencyValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        log.info("Starting from currency validation");
        if (deal.toCurrencyIsoCode() == null ||
                deal.toCurrencyIsoCode().isEmpty()) {
            throw new FieldMustNotBeEmpty("To currency must not be empty");
        }
    }
}
