package bitcoinstoreservice.feignclient;

import bitcoinstoreservice.domain.Market;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "market-client", url = "https://api.upbit.com/v1/market/all")
public interface MarketClient {
    @GetMapping(produces = "application/json")
    public List<Market> getMarketList(@RequestParam("isDetails") boolean isDetail);
}
