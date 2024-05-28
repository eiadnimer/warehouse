package me.eiad.warehouse;

import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.core.DealRepository;

import java.util.ArrayList;
import java.util.List;

public class MockDealRepository implements DealRepository {
    private Deal deal;
    public final List<Deal> deals = new ArrayList<>();

    @Override
    public Deal save(Deal deal) {
        deals.add(deal);
        return deal;
    }

}
