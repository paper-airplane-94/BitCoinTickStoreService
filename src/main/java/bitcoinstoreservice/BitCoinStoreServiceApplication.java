package bitcoinstoreservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan
@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class BitCoinStoreServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(BitCoinStoreServiceApplication.class, args);
    }
}
