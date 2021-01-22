package osvaldas.games.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import osvaldas.games.config.AppConfig;
import osvaldas.games.interfaces.MessageGenerator;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//        int number = numberGenerator.next();
//        log.info("number = {}", number);

        MessageGenerator messageGenerator
                = context.getBean(MessageGenerator.class);

        log.info("getMainMessage() = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage() = {}", messageGenerator.getResultMessage());

        context.close();
    }
}