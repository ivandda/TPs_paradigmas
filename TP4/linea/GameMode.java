package linea;

import java.util.ArrayList;

public class GameMode {
    public static final String invalid_game_mode_choice = "Invalid game mode reference";
    private static ArrayList<GameMode> possibleGameModes = new ArrayList<>(java.util.Arrays.asList(
            new GMA(),
            new GMB(),
            new GMC()
    ));
    protected char identifier;

    public static GameMode setGameMode(char choice) {
        return possibleGameModes.stream()
                .filter(gameMode -> gameMode.applies(choice))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(invalid_game_mode_choice));
    }

    public boolean applies(char gameModeIdentifier) {
        return identifier == gameModeIdentifier;
    }
}
