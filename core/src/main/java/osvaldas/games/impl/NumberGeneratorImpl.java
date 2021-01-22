package osvaldas.games.impl;

import org.springframework.beans.factory.annotation.Autowired;
import osvaldas.games.interfaces.NumberGenerator;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    @Autowired
    private int maxNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
