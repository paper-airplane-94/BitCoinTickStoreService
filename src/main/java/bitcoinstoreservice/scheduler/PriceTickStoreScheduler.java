package bitcoinstoreservice.scheduler;

import bitcoinstoreservice.service.TickPriceStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PriceTickStoreScheduler {
    private TickPriceStoreService tickPriceStoreService;

    @Autowired
    public PriceTickStoreScheduler(TickPriceStoreService tickPriceStoreService) {
        this.tickPriceStoreService = tickPriceStoreService;
    }

    @Scheduled(fixedDelay = 125)
    public void insertPriceTick() {
        tickPriceStoreService.insertPriceTick("KRW-ETC");
    }
}
