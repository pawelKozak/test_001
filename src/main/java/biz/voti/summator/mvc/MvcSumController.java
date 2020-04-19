package biz.voti.summator.mvc;

import biz.voti.summator.request.IntRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/sum")
public class MvcSumController {
    private final MvcSumService sumService;

    public MvcSumController(final MvcSumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> sumWithExternal(@RequestBody final IntRequest request) {
        return new ResponseEntity<>(sumService.addToExternalInt(request.getValue()), HttpStatus.OK);
    }
}
