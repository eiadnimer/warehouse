package me.eiad.warehouse.core.validations;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.FieldMustNotBeEmpty;

public class ToCurrencyValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        if (deal.toCurrencyIsoCode() == null ||
                deal.toCurrencyIsoCode().isEmpty()) {
            throw new FieldMustNotBeEmpty("To currency must not be empty");
        }
    }
}
