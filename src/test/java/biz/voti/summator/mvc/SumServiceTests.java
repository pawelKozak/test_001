package biz.voti.summator.mvc;

import biz.voti.summator.services.external.ExternalService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SumServiceTests {

    @Test
    public void givenNumberShouldReturnGreaterValue() {
        // given
        int number = 5;
        int externalValue = 10;
        int expected = number + externalValue;

        ExternalService externalService = mock(ExternalService.class);
        when(externalService.getValue()).thenReturn(externalValue);

        MvcSumService sumService = new MvcSumService(externalService);

        // when
        int result = sumService.addToExternalInt(number);

        // then
        Assert.assertEquals(expected, result);
    }
}
