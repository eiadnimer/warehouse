package me.eiad.warehouse.core;


import lombok.Getter;
import me.eiad.warehouse.core.validations.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Deal(long uniqueId,
                   String fromCurrencyIsoCode,
                   String toCurrencyIsoCode,
                   LocalDate dealTimestamp,
                   BigDecimal amount) {

    private static final List<DealValidation> validations = new ArrayList<>();

    static {
        validations.add(new IdValidation());
        validations.add(new TimestampValidation());
        validations.add(new AmountValidation());
        validations.add(new FromCurrencyValidation());
        validations.add(new ToCurrencyValidation());
        validations.add(new ISOValidation());
    }

    public Deal(long uniqueId, String fromCurrencyIsoCode, String toCurrencyIsoCode,
                LocalDate dealTimestamp, BigDecimal amount) {
        this.uniqueId = uniqueId;
        this.fromCurrencyIsoCode = fromCurrencyIsoCode;
        this.toCurrencyIsoCode = toCurrencyIsoCode;
        this.dealTimestamp = dealTimestamp;
        this.amount = amount;
        validateDeal();
    }

    private void validateDeal() {
        for (DealValidation validation : validations) {
            validation.validate(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return uniqueId == deal.uniqueId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueId);
    }

    @Override
    public String toString() {
        return "Deal{" +
                ", fromCurrencyIsoCode='" + fromCurrencyIsoCode + '\'' +
                ", toCurrencyIsoCode='" + toCurrencyIsoCode + '\'' +
                ", dealTimestamp=" + dealTimestamp +
                ", amount=" + amount +
                '}';
    }
}
