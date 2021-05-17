package org.investment.bitcoin.bitcointickstoreservice.service;

import org.investment.bitcoin.bitcointickstoreservice.domain.Market;
import org.investment.bitcoin.bitcointickstoreservice.feignclient.MarketClient;
import org.investment.bitcoin.bitcointickstoreservice.mapper.MarketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketStoreService {
    private MarketClient marketClient;
    private MarketMapper marketMapper;

    @Autowired
    public MarketStoreService(MarketClient marketClient, MarketMapper marketMapper){
        this.marketClient = marketClient;
        this.marketMapper = marketMapper;
    }

    public void updateMarketInformation(boolean isDetail){
        List<Market> markets = getMarketInformationFromAPI(true);
        marketMapper.insertMarketList(markets);
    }

    public List<Market> getMarketInformationFromAPI(boolean isDetail){
        return marketClient.getMarketListFromAPI(isDetail);
    }

    public List<Market> getMarketInformationFromAPI(){
        return marketMapper.selectMarketList();
    }
}
