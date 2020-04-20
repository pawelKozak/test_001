package biz.voti.summator;

import biz.voti.summator.reactive.ReactiveSumConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class SumApplication {

    public static void main(final String[] args) {
        Class<?>[] configurations = {
                SumApplication.class,
                ServerConfiguration.class,
                ReactiveSumConfiguration.class
        };

        SpringApplication.run(configurations,  args);
    }
}
