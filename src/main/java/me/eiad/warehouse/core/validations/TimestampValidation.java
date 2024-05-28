package me.eiad.warehouse.core.validations;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.FieldMustNotBeEmpty;
import me.eiad.warehouse.exceptions.NoDealInFuture;

import java.time.LocalDate;

@Slf4j
public class TimestampValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        log.info("Starting timestamp validation");
        if (deal.dealTimestamp() == null) {
            throw new FieldMustNotBeEmpty("Deal timestamp must not be empty");
        }
        if (deal.dealTimestamp().isAfter(LocalDate.now())) {
            throw new NoDealInFuture("Deal timestamp must not be in future");
        }
    }
}
