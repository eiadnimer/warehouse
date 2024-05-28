package me.eiad.warehouse.repository;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.core.DealMapper;
import me.eiad.warehouse.core.DealRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SpringDataDealRepository implements DealRepository {

    private final SpringDealRepository springDealRepository;
    private final DealMapper dealMapper;

    public SpringDataDealRepository(SpringDealRepository springDealRepository, DealMapper dealMapper) {
        this.springDealRepository = springDealRepository;
        this.dealMapper = dealMapper;
    }

    @Override
    public Deal save(Deal deal) {
        DealEntity savedDeal = springDealRepository.save(dealMapper.toEntity(deal));
        return dealMapper.toModel(savedDeal);
    }
}
