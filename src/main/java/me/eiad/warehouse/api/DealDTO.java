package me.eiad.warehouse.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class DealDTO {
    private long uniqueId;
    private String fromCurrencyIsoCode;
    private String toCurrencyIsoCode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dealTimestamp;
    private BigDecimal amount;

    public DealDTO(long uniqueId, String fromCurrencyIsoCode,
                   String toCurrencyIsoCode, LocalDate dealTimestamp, BigDecimal amount) {
        this.uniqueId = uniqueId;
        this.fromCurrencyIsoCode = fromCurrencyIsoCode;
        this.toCurrencyIsoCode = toCurrencyIsoCode;
        this.dealTimestamp = dealTimestamp;
        this.amount = amount;
    }

    public DealDTO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealDTO dealDTO = (DealDTO) o;
        return uniqueId == dealDTO.uniqueId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueId);
    }

    @Override
    public String toString() {
        return "DealDTO{" +
                ", fromCurrencyIsoCode='" + fromCurrencyIsoCode + '\'' +
                ", toCurrencyIsoCode='" + toCurrencyIsoCode + '\'' +
                ", dealTimestamp=" + dealTimestamp +
                ", amount=" + amount +
                '}';
    }
}
