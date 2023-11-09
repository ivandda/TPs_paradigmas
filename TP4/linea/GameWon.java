package linea;

import java.util.ArrayList;

public class GameWon extends GameState {
    @Override
    public void checkRedCanPlay() {throw new RuntimeException(redCantPlayMessage);}

    @Override
    public void checkBlueCanPlay() {throw new RuntimeException(blueCantPlayMessage);}
}
