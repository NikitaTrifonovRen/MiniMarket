package ed.core.minimarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MiniMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniMarketApplication.class, args);
    }

}
