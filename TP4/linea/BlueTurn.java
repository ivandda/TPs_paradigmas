package linea;

import java.util.ArrayList;

public class BlueTurn extends GameState {
    @Override
    public void checkRedCanPlay() {throw new RuntimeException(redCantPlayMessage);}

    @Override
    public void checkBlueCanPlay() {}
}
