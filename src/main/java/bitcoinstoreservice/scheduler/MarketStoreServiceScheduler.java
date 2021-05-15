package bitcoinstoreservice.scheduler;

import bitcoinstoreservice.service.MarketStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MarketStoreServiceScheduler {
    private MarketStoreService marketStoreService;

    @Autowired
    public MarketStoreServiceScheduler(MarketStoreService marketStoreService) {
        this.marketStoreService = marketStoreService;
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void updateMarketInformation() {
        marketStoreService.updateMarketInformation(true);
    }
}
