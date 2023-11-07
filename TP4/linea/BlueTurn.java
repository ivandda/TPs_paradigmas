package linea;

import java.util.ArrayList;

public class BlueTurn extends GameState {
    @Override
    public char getPiece() {
        return 'B';
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsRedAt(int position, ArrayList<ArrayList<Character>> board) {
        return board;
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsBlueAt(int position, ArrayList<ArrayList<Character>> board) {
        ArrayList<ArrayList<Character>> newBoard = board;
        newBoard.get(position).add(getPiece());
        return newBoard;
    }
}
