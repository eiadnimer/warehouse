package me.eiad.warehouse.core;

import me.eiad.warehouse.api.DealDTO;


public class DealsService {

    private final DealRepository dealRepository;

    public DealsService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public Deal saveDeal(DealDTO dealDTO) {
        Deal deal = new Deal(dealDTO.getUniqueId(),
                dealDTO.getFromCurrencyIsoCode(),
                dealDTO.getToCurrencyIsoCode(),
                dealDTO.getDealTimestamp(),
                dealDTO.getAmount());
        return dealRepository.save(deal);
    }
}
