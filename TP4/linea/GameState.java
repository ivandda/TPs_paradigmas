package linea;

import java.util.ArrayList;

public abstract class GameState {
    protected String blueCantPlayMessage = "Blue cant play in this round";
    protected String redCantPlayMessage = "Red cant play in this round";
    public abstract void checkRedCanPlay();
    public abstract void checkBlueCanPlay();

}
