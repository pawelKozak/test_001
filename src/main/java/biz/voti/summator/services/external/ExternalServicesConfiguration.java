package biz.voti.summator.services.external;

import biz.voti.summator.WebClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import(WebClientConfiguration.class)
public class ExternalServicesConfiguration {
    private final String RANDOM_API_GENERATOR_URI
            = "https://www.random.org/integers/?num=1&min=0&max=%d&col=1&base=10&format=plain&rnd=new";

    private final int upperBound = 10;

    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGenerator(upperBound);
    }

    @Bean
    public ExternalService externalService(final WebClient webClient) {
        return new ExternalService(formatExternalServiceUrl(), webClient);
    }

    private String formatExternalServiceUrl() {
        return String.format(RANDOM_API_GENERATOR_URI, upperBound);
    }
}
