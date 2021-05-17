package org.investment.bitcoin.bitcointickstoreservice.mapper;

import org.investment.bitcoin.bitcointickstoreservice.domain.Market;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketMapper {
    public List<Market> selectMarketList();
    public void insertMarketList(List<Market> markets);
}
