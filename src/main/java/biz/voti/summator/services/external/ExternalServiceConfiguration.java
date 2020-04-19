package biz.voti.summator.services.external;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalServiceConfiguration {

    @Bean
    public ExternalService externalService() {
        return new ExternalService();
    }
}
