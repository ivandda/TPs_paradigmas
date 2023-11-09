package linea;

import java.util.ArrayList;

public class RedTurn extends GameState {
    @Override
    public void checkRedCanPlay() {}

    @Override
    public void checkBlueCanPlay() {throw new RuntimeException(blueCantPlayMessage);}
}
