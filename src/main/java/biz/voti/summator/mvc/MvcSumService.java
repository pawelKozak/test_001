package biz.voti.summator.mvc;

import biz.voti.summator.services.external.ExternalService;

public class MvcSumService {
    private final ExternalService externalService;

    public MvcSumService(final ExternalService externalService) {
        this.externalService = externalService;
    }

    public int addToExternalInt(final int number) {
        return externalService.getValue() + number;
    }
}
