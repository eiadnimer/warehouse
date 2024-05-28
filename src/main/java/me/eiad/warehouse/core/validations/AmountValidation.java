package me.eiad.warehouse.core.validations;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.exceptions.AmountIsMinus;
import me.eiad.warehouse.exceptions.FieldMustNotBeEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmountValidation implements DealValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmountValidation.class);

    @Override
    public void validate(Deal deal) {
        LOGGER.info("starting amount validation");
        if (deal.amount() == null) {
            throw new FieldMustNotBeEmpty("Amount must not be empty");
        }
        if (deal.amount().signum() < 0) {
            throw new AmountIsMinus();
        }
    }
}
