package me.eiad.warehouse.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "deals")
@Getter
@Setter
public class DealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "unique_id", unique = true)
    private long uniqueId;
    @Column(name = "from_currency_iso_code")
    private String fromCurrencyIsoCode;
    @Column(name = "to_currency_iso_code")
    private String toCurrencyIsoCode;
    @Column(name = "deal_timestamp")
    private LocalDate dealTimestamp;
    @Column(name = "amount")
    private BigDecimal amount;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealEntity that = (DealEntity) o;
        return uniqueId == that.uniqueId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueId);
    }

    @Override
    public String toString() {
        return "DealEntity{" +
                ", fromCurrencyIsoCode='" + fromCurrencyIsoCode + '\'' +
                ", toCurrencyIsoCode='" + toCurrencyIsoCode + '\'' +
                ", dealTimestamp=" + dealTimestamp +
                ", amount=" + amount +
                '}';
    }
}
