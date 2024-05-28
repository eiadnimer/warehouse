package me.eiad.warehouse;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.core.validations.*;
import me.eiad.warehouse.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DealTest {

    private final Deal deal = new Deal(1, "JOD", "JOD",
            LocalDate.now(), new BigDecimal(2));

    @Test
    public void id_must_be_not_minus_otherwise_must_fail() {
        Assertions.assertThrows(IdMustBePositive.class,
                () -> new Deal(-2, "", "JOD",
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void must_not_throws_any_exceptions_when_the_IdValidation_is_valid() {
        IdValidation idValidation = new IdValidation();

        Assertions.assertDoesNotThrow(() -> {
            idValidation.validate(deal);
        });
    }

    @Test
    public void must_not_throws_any_exceptions_when_the_ISOValidation_is_valid() {
        ISOValidation isoValidation = new ISOValidation();

        Assertions.assertDoesNotThrow(() -> {
            isoValidation.validate(deal);
        });
    }

    @Test
    public void from_currency_should_be_not_empty_otherwise_must_fail() {
        Assertions.assertThrows(FieldMustNotBeEmpty.class,
                () -> new Deal(1, "", "JOD",
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void from_currency_should_be_not_null_otherwise_must_fail() {
        Assertions.assertThrows(FieldMustNotBeEmpty.class,
                () -> new Deal(1, null, "JOD",
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void from_currency_should_be_upperCase_otherwise_must_fail() {
        Assertions.assertThrows(MustBeUpperCase.class,
                () -> new Deal(1, "jod", "JOD",
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void to_currency_should_be_not_empty_otherwise_must_fail() {
        Assertions.assertThrows(FieldMustNotBeEmpty.class,
                () -> new Deal(1, "JOD", "",
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void must_not_throws_any_exceptions_when_the_from_currency_is_valid() {
        FromCurrencyValidation fromCurrencyValidation = new FromCurrencyValidation();

        Assertions.assertDoesNotThrow(() -> {
            fromCurrencyValidation.validate(deal);
        });
    }

    @Test
    public void to_currency_should_be_not_null_otherwise_must_fail() {
        Assertions.assertThrows(FieldMustNotBeEmpty.class,
                () -> new Deal(1, "JOD", null,
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void to_currency_should_be_upperCase_otherwise_must_fail() {
        Assertions.assertThrows(MustBeUpperCase.class,
                () -> new Deal(1, "JOD", "jod",
                        LocalDate.now(), new BigDecimal(2)));
    }

    @Test
    public void must_not_throws_any_exceptions_when_the_deals_is_valid() {
        ToCurrencyValidation toCurrencyValidation = new ToCurrencyValidation();

        Assertions.assertDoesNotThrow(() -> {
            toCurrencyValidation.validate(deal);
        });
    }

    @Test
    public void timestamp_should_be_not_null_otherwise_must_fail() {
        Assertions.assertThrows(FieldMustNotBeEmpty.class,
                () -> new Deal(1, "", "JOD",
                        null, new BigDecimal(2)));
    }

    @Test
    public void timestamp_should_be_in_past_or_now_otherwise_must_fail() {
        Assertions.assertThrows(NoDealInFuture.class,
                () -> new Deal(1, "", "JOD",
                        LocalDate.parse("2222-01-05"), new BigDecimal(2)));
    }

    @Test
    public void must_not_throws_any_exceptions_when_the_timestamp_is_valid() {
        TimestampValidation timestampValidation = new TimestampValidation();

        Assertions.assertDoesNotThrow(() -> {
            timestampValidation.validate(deal);
        });
    }

    @Test
    public void amount_should_not_be_minus_otherwise_must_fail() {
        Assertions.assertThrows(AmountIsMinus.class,
                () -> new Deal(1, "", "JOD",
                        LocalDate.now(), new BigDecimal(-5)));
    }

    @Test
    public void amount_should_not_be_null_otherwise_must_fail() {
        Assertions.assertThrows(FieldMustNotBeEmpty.class,
                () -> new Deal(1, "", "JOD", LocalDate.now(), null));
    }

    @Test
    public void must_not_throws_any_exceptions_when_the_amount_is_valid() {
        AmountValidation amountValidation = new AmountValidation();

        Assertions.assertDoesNotThrow(() -> {
            amountValidation.validate(deal);
        });
    }
}
