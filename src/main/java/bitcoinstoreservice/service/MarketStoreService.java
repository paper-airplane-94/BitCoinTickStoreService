package bitcoinstoreservice.service;

import bitcoinstoreservice.domain.Market;
import bitcoinstoreservice.feignclient.MarketClient;
import bitcoinstoreservice.mapper.MarketMapper;
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
        List<Market> markets = getMarketInformation(true);
        marketMapper.insertMarketList(markets);
    }

    public List<Market> getMarketInformation(boolean isDetail){
        return marketClient.getMarketList(isDetail);
    }
}
