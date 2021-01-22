package osvaldas.games.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import osvaldas.games.annotation.MaxNumber;
import osvaldas.games.annotation.MinNumber;
import osvaldas.games.interfaces.NumberGenerator;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    @Getter
    @MaxNumber
    private final int maxNumber;

    @Getter
    @MinNumber
    private final int minNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }
}
