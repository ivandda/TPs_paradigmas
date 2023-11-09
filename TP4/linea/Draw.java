package linea;

import java.util.ArrayList;

public class Draw extends GameState{
    @Override
    public void checkRedCanPlay() {throw new RuntimeException(redCantPlayMessage);}

    @Override
    public void checkBlueCanPlay() {throw new RuntimeException(blueCantPlayMessage);}
}
