package osvaldas.games.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import osvaldas.games.impl.GameImpl;
import osvaldas.games.impl.MessageGeneratorImpl;
import osvaldas.games.impl.NumberGeneratorImpl;
import osvaldas.games.interfaces.Game;
import osvaldas.games.interfaces.MessageGenerator;
import osvaldas.games.interfaces.NumberGenerator;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "osvaldas.games")
public class AppConfig {

    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
