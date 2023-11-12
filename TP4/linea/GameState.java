package linea;

import java.util.ArrayList;

public abstract class GameState {
    private static ArrayList<GameState> possibleGameStates = new ArrayList<>(java.util.Arrays.asList(
            new RedTurn(),
            new BlueTurn(),
            new RedWon(),
            new BlueWon(),
            new Draw()
    ));
    protected String blueCantPlayMessage = "Blue cant play in this round";
    protected String redCantPlayMessage = "Red cant play in this round";
    public abstract void checkRedCanPlay();
    public abstract void checkBlueCanPlay();
    public abstract boolean isFinished();
    public abstract boolean isRedTurn();
    public abstract boolean isBlueTurn();
//    public abstract boolean isNext();

//    public GameState getNextState(){
//        return possibleGameStates.stream().filter(gameState -> gameState.isNext()).findFirst().get();
//    }



}
