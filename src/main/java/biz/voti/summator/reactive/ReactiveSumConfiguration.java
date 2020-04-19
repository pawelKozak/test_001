package biz.voti.summator.reactive;

import biz.voti.summator.services.external.ExternalService;
import biz.voti.summator.services.external.ExternalServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ExternalServiceConfiguration.class)
public class ReactiveSumConfiguration {
    private final ExternalService externalService;

    public ReactiveSumConfiguration(final ExternalService externalService) {
        this.externalService = externalService;
    }

    @Bean
    public ReactiveSumController reactiveSumController() {
        return new ReactiveSumController(reactiveExternalService());
    }

    @Bean
    ReactiveSumService reactiveExternalService() {
        return new ReactiveSumService(externalService);
    }
}
