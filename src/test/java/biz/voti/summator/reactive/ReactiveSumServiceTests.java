package biz.voti.summator.reactive;

import biz.voti.summator.services.external.ExternalService;
import biz.voti.summator.services.external.NumberGenerator;
import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReactiveSumServiceTests {

    @Test
    public void givenNumberShouldReturnGreaterValue() {
        // given
        int generatedNumber = 5;
        int externalValue = 10;
        int expected = generatedNumber + externalValue;

        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.getValue()).thenReturn(generatedNumber);

        ExternalService externalService = mock(ExternalService.class);
        when(externalService.getNextAsync()).thenReturn(Mono.just(externalValue));

        ReactiveSumService sumService = new ReactiveSumService(numberGenerator, externalService);

        // when
        int result = sumService.sum().block();

        // then
        Assert.assertEquals(expected, result);
    }
}
