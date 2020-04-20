package biz.voti.summator.services.external;

import java.util.Random;

public class NumberGenerator {
    private final Random random = new Random();
    private final int upperBound;

    public NumberGenerator(final int upperBound) {
        this.upperBound = upperBound;
    }

    public int getValue() {
        return random.nextInt(upperBound);
    }
}
