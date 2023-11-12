package linea;

public class RedWon extends GameState {
    @Override
    public void checkRedCanPlay() {throw new RuntimeException(redCantPlayMessage);}

    @Override
    public void checkBlueCanPlay() {throw new RuntimeException(blueCantPlayMessage);}

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isRedTurn() {
        return false;
    }

    @Override
    public boolean isBlueTurn() {
        return false;
    }
}
