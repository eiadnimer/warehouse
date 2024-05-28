package me.eiad.warehouse.api;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.core.Deal;
import me.eiad.warehouse.core.DealMapper;
import me.eiad.warehouse.core.DealsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@Slf4j
public class DealsController {

    private final DealsService dealsService;
    private final DealMapper dealMapper;

    public DealsController(DealsService dealsService, DealMapper dealMapper) {
        this.dealsService = dealsService;
        this.dealMapper = dealMapper;
    }

    @PostMapping("deal")
    public ResponseEntity<DealDTO> saveDeal(@RequestBody DealDTO dealDTO) {
        log.info("New deal is received {}", dealDTO.toString());
        Deal savedDeal = dealsService.saveDeal(dealDTO);
        log.info("Deal was saved with id {}", savedDeal.uniqueId());
        return ResponseEntity
                .created(URI.create("/deal/" + savedDeal.uniqueId()))
                .body(dealMapper.toDTO(savedDeal));
    }
}
