package me.eiad.warehouse.core;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.api.DealDTO;

@Slf4j
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
        log.info("Deal was created successful {}", deal.toString());
        return dealRepository.save(deal);
    }
}
