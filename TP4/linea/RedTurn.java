package linea;

import java.util.ArrayList;

public class RedTurn extends GameState {
    @Override
    public char getPiece() {
        return 'R';
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsRedAt(int position, ArrayList<ArrayList<Character>> board) {
        ArrayList<ArrayList<Character>> newBoard = board;
        newBoard.get(position).add(getPiece());
        return newBoard;
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsBlueAt(int position, ArrayList<ArrayList<Character>> board) {
        return board;
    }
}
