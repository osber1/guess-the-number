package osvaldas.games.console;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import osvaldas.games.interfaces.Game;
import osvaldas.games.interfaces.MessageGenerator;

import java.util.Scanner;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsoleNumberGuess {

    private final Game game;
    private final MessageGenerator messageGenerator;

    @EventListener()
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
