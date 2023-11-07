package linea;

import java.util.ArrayList;

public class RedTurn extends CurrentTurn {
    char charIdentifier = 'R';

    @Override
    public ArrayList<ArrayList<Character>> playAsRedAt(int position, ArrayList<ArrayList<Character>> board) {
        ArrayList<ArrayList<Character>> newBoard = board;
        newBoard.get(position).add(charIdentifier);
        return newBoard;
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsBlueAt(int position, ArrayList<ArrayList<Character>> board) {
        return board;
    }
}
