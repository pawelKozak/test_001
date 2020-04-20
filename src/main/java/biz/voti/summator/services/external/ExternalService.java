package biz.voti.summator.services.external;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

public class ExternalService {
    private final String url;
    private final WebClient client;

    public ExternalService(final String url,
                           final WebClient webClient) {
        this.url = url;
        this.client = webClient;
    }

    public Mono<Integer> getNextAsync() {
        return client.get()
                .uri(URI.create(url))
                .retrieve()
                .bodyToMono(String.class)
                .map(String::trim)
                .map(Integer::valueOf);
    }
}
