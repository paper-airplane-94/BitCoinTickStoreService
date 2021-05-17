package org.investment.bitcoin.bitcointickstoreservice.feignclient;

import org.investment.bitcoin.bitcointickstoreservice.domain.TickPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "bitcoinTick-client", url = "https://api.upbit.com/v1/ticker")
public interface TickPriceClient {
    @GetMapping(produces = "application/json")
    public List<TickPrice> getTickPrice(@RequestParam("markets") String market);
}
