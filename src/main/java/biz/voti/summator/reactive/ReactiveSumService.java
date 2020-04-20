package biz.voti.summator.reactive;

import biz.voti.summator.services.external.ExternalService;
import biz.voti.summator.services.external.NumberGenerator;
import reactor.core.publisher.Mono;

public class ReactiveSumService {
    private final NumberGenerator numberGenerator;
    private final ExternalService externalService;

    public ReactiveSumService(final NumberGenerator numberGenerator,
                              final ExternalService externalService) {
        this.numberGenerator = numberGenerator;
        this.externalService = externalService;
    }

    public Mono<Integer> sum() {
        return Mono.from(externalService.getNextAsync())
                    .map(value -> value + numberGenerator.getValue());
    }
}
