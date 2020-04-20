package biz.voti.summator;

import biz.voti.summator.utils.WebClientUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    private final int timeout = 5000;

    @Bean
    public WebClient webClient() {
        return WebClientUtils.createWebClient(timeout);
    }
}
