package org.investment.bitcoin.bitcointickstoreservice.scheduler;

import org.investment.bitcoin.bitcointickstoreservice.domain.Market;
import org.investment.bitcoin.bitcointickstoreservice.service.MarketStoreService;
import org.investment.bitcoin.bitcointickstoreservice.service.TickPriceStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PriceTickStoreScheduler {
    private TickPriceStoreService tickPriceStoreService;
    private MarketStoreService marketStoreService;

    @Autowired
    public PriceTickStoreScheduler(TickPriceStoreService tickPriceStoreService, MarketStoreService marketStoreService) {
        this.tickPriceStoreService = tickPriceStoreService;
        this.marketStoreService = marketStoreService;
    }

    @Scheduled(cron = "*/1 * * * * *")
    public void insertPriceTick() {
        List<Market> markets = marketStoreService.getMarketInformationFromAPI();
        markets.stream().forEach(market -> {
            try {
                Thread.sleep(100);
                tickPriceStoreService.insertPriceTick(market.getMarketId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
