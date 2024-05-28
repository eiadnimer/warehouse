package me.eiad.warehouse.core.validations;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.FieldMustNotBeEmpty;
import me.eiad.warehouse.exceptions.NoDealInFuture;

import java.time.LocalDate;


public class TimestampValidation implements DealValidation {
    @Override
    public void validate(Deal deal) {
        if (deal.dealTimestamp() == null) {
            throw new FieldMustNotBeEmpty("Deal timestamp must not be empty");
        }
        if (deal.dealTimestamp().isAfter(LocalDate.now())){
            throw new NoDealInFuture();
        }
    }
}
