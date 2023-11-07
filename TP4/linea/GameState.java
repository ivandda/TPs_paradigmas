package linea;

import java.util.ArrayList;

public abstract class GameState {
    public abstract ArrayList<ArrayList<Character>> playAsRedAt(int position, ArrayList<ArrayList<Character>> board);

    public abstract ArrayList<ArrayList<Character>> playAsBlueAt(int position, ArrayList<ArrayList<Character>> board);

    public abstract char getPiece();
}
