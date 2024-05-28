package me.eiad.warehouse.core.validations;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.IdMustBePositive;

@Slf4j
public class IdValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        log.info("Starting id validation");
        if (deal.uniqueId() < 0) {
            throw new IdMustBePositive("Unique id must be positive");
        }
    }
}
