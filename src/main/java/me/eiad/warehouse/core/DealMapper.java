package me.eiad.warehouse.core;

import me.eiad.warehouse.api.DealDTO;
import me.eiad.warehouse.repository.DealEntity;

public class DealMapper {

    public DealEntity toEntity(Deal deal) {
        DealEntity dealEntity = new DealEntity();
        dealEntity.setUniqueId(deal.uniqueId());
        dealEntity.setFromCurrencyIsoCode(deal.fromCurrencyIsoCode());
        dealEntity.setToCurrencyIsoCode(deal.toCurrencyIsoCode());
        dealEntity.setDealTimestamp(deal.dealTimestamp());
        dealEntity.setAmount(deal.amount());
        return dealEntity;
    }

    public Deal toModel(DealEntity entity) {
        return new Deal(entity.getUniqueId(), entity.getFromCurrencyIsoCode(),
                entity.getToCurrencyIsoCode(), entity.getDealTimestamp(),
                entity.getAmount());
    }

    public Deal toModel(DealDTO dealDTO) {
        return new Deal(dealDTO.getUniqueId(), dealDTO.getFromCurrencyIsoCode(),
                dealDTO.getToCurrencyIsoCode(), dealDTO.getDealTimestamp(), dealDTO.getAmount());
    }

    public DealDTO toDTO(Deal deal) {
        return new DealDTO(deal.uniqueId(), deal.fromCurrencyIsoCode(), deal.toCurrencyIsoCode(),
                deal.dealTimestamp(), deal.amount());
    }

}
