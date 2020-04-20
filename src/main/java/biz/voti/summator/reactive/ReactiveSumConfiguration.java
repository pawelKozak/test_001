package biz.voti.summator.reactive;

import biz.voti.summator.services.external.ExternalService;
import biz.voti.summator.services.external.NumberGenerator;
import biz.voti.summator.services.external.ExternalServicesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ExternalServicesConfiguration.class)
public class ReactiveSumConfiguration {
    private final NumberGenerator numberGenerator;
    private final ExternalService externalService;

    public ReactiveSumConfiguration(final NumberGenerator numberGenerator, final ExternalService externalService) {
        this.numberGenerator = numberGenerator;
        this.externalService = externalService;
    }

    @Bean
    public ReactiveSumController reactiveSumController() {
        return new ReactiveSumController(reactiveExternalService());
    }

    @Bean
    ReactiveSumService reactiveExternalService() {
        return new ReactiveSumService(numberGenerator, externalService);
    }
}
