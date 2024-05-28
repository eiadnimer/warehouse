package me.eiad.warehouse.core.validations;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.FieldMustNotBeEmpty;

public class FromCurrencyValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        if (deal.fromCurrencyIsoCode() == null ||
                deal.fromCurrencyIsoCode().isEmpty()) {
            throw new FieldMustNotBeEmpty("From currency must not be empty");
        }
    }
}
