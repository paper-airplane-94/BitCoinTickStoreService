package org.investment.bitcoin.bitcointickstoreservice.service;

import org.investment.bitcoin.bitcointickstoreservice.domain.TickPrice;
import org.investment.bitcoin.bitcointickstoreservice.feignclient.TickPriceClient;
import org.investment.bitcoin.bitcointickstoreservice.mapper.TickPriceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TickPriceStoreService {
    private TickPriceClient tickPriceClient;
    private TickPriceMapper tickPriceMapper;

    @Autowired
    public TickPriceStoreService(TickPriceClient tickPriceClient, TickPriceMapper tickPriceMapper){
        this.tickPriceClient = tickPriceClient;
        this.tickPriceMapper = tickPriceMapper;
    }

    public void insertPriceTick(String marketId){
        List<TickPrice> tickPrices = getPriceTick(marketId);
        tickPriceMapper.insertPriceTick(tickPrices);
    }

    public List<TickPrice> getPriceTick(String marketId){
        return tickPriceClient.getTickPrice(marketId);
    }
}
