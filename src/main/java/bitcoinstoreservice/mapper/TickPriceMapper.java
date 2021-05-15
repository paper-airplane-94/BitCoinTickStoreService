package bitcoinstoreservice.mapper;

import bitcoinstoreservice.domain.TickPrice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TickPriceMapper {
    public void insertPriceTick(List<TickPrice> tickPrices);
}
