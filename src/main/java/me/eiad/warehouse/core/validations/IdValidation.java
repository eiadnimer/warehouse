package me.eiad.warehouse.core.validations;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.IdMustBePositive;

public class IdValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        if (deal.uniqueId() < 0) {
            throw new IdMustBePositive();
        }
    }
}
