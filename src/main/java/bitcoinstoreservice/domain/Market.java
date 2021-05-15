package bitcoinstoreservice.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Market {

    @JsonProperty("market")
    String marketId;

    @JsonProperty("korean_name")
    String koreaName;

    @JsonProperty("english_name")
    String englishName;

    @JsonProperty("market_warning")
    String warning;
}
