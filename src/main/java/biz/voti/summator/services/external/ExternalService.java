package biz.voti.summator.services.external;

import java.util.Random;

public class ExternalService {
    private final Random random = new Random();

    public int getValue() {
        return random.nextInt();
    }
}
