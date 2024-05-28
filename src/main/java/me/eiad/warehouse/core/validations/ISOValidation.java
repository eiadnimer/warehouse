package me.eiad.warehouse.core.validations;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.MustBeUpperCase;

@Slf4j
public class ISOValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        log.info("Starting ISO validation");
        if (!deal.toCurrencyIsoCode().equals(deal.toCurrencyIsoCode().toUpperCase())) {
            throw new MustBeUpperCase("Currency must be upper case");
        }
        if (!deal.fromCurrencyIsoCode().equals(deal.fromCurrencyIsoCode().toUpperCase())) {
            throw new MustBeUpperCase("Currency must be upper case");
        }
    }
}
