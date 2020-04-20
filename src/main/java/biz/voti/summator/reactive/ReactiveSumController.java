package biz.voti.summator.reactive;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RequestMapping("/api/sum")
public class ReactiveSumController {
    private final ReactiveSumService sumService;

    public ReactiveSumController(final ReactiveSumService sumService) {
        this.sumService = sumService;
    }

    @GetMapping
    public Mono<ResponseEntity<Integer>> sum() {
        return sumService.sum()
                    .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                    ;
    }
}
