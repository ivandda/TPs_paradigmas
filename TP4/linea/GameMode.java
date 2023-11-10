package linea;

public class GameMode {
    protected char identifier;

    public boolean applies(char gameModeIdentifier) {
        return identifier == gameModeIdentifier;
    }
}
