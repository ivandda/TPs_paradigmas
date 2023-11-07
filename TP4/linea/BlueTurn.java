package linea;

import java.util.ArrayList;

public class BlueTurn extends CurrentTurn {
    char charIdentifier = 'B';


    @Override
    public ArrayList<ArrayList<Character>> playAsRedAt(int position, ArrayList<ArrayList<Character>> board) {
        return board;
    }

    @Override
    public ArrayList<ArrayList<Character>> playAsBlueAt(int position, ArrayList<ArrayList<Character>> board) {
        ArrayList<ArrayList<Character>> newBoard = board;
        newBoard.get(position).add(charIdentifier);
        return newBoard;
    }
}
