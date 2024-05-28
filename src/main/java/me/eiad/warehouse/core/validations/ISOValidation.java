package me.eiad.warehouse.core.validations;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.MustBeUpperCase;

public class ISOValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        if (!deal.toCurrencyIsoCode().equals(deal.toCurrencyIsoCode().toUpperCase())) {
            throw new MustBeUpperCase();
        }
        if (!deal.fromCurrencyIsoCode().equals(deal.fromCurrencyIsoCode().toUpperCase())) {
            throw new MustBeUpperCase();
        }
    }
}
