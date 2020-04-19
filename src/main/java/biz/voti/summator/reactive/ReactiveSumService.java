package biz.voti.summator.reactive;

import biz.voti.summator.services.external.ExternalService;
import reactor.core.publisher.Mono;

public class ReactiveSumService {
    private final ExternalService externalService;

    public ReactiveSumService(final ExternalService externalService) {
        this.externalService = externalService;
    }

    public Mono<Integer> sumWithExternal(final int number) {
        return Mono.just(number)
                    .map(value -> externalService.getValue() + value);
    }
}
