package biz.voti.summator.reactive;

import biz.voti.summator.request.IntRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RequestMapping("/api/reactive/sum")
public class ReactiveSumController {
    private final ReactiveSumService sumService;

    public ReactiveSumController(final ReactiveSumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Integer>> sumWithExternal(@RequestBody final IntRequest request) {
        return sumService.sumWithExternal(request.getValue())
                    .map(result -> new ResponseEntity<>(result, HttpStatus.OK));
    }
}
