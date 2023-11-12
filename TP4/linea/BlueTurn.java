package linea;

import java.util.ArrayList;

public class BlueTurn extends GameState {
    @Override
    public void checkRedCanPlay() {throw new RuntimeException(redCantPlayMessage);}

    @Override
    public void checkBlueCanPlay() {}

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isRedTurn() {
        return false;
    }

    @Override
    public boolean isBlueTurn() {
        return true;
    }
}
