package osvaldas.games.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import osvaldas.games.config.GameConfig;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}