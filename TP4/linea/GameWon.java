package linea;

import java.util.ArrayList;

public class GameWon extends GameState{
    @Override
    public char getPiece() {
        return 0;
    }
    @Override
    public ArrayList<ArrayList<Character>> playAsRedAt(int position, ArrayList<ArrayList<Character>> board) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsBlueAt(int position, ArrayList<ArrayList<Character>> board) {
        return null;
    }
}
