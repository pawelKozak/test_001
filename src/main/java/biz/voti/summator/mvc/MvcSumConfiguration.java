package biz.voti.summator.mvc;

import biz.voti.summator.services.external.ExternalService;
import biz.voti.summator.services.external.ExternalServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ExternalServiceConfiguration.class)
public class MvcSumConfiguration {
    private final ExternalService externalService;

    public MvcSumConfiguration(final ExternalService externalService) {
        this.externalService = externalService;
    }

    @Bean
    public MvcSumController sumController() {
        return new MvcSumController(sumService());
    }

    @Bean
    MvcSumService sumService() {
        return new MvcSumService(externalService);
    }
}
