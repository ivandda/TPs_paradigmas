package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
    public static final char redPiece = 'R';
    public static final char bluePiece = 'B';
    public static final char emptyPiece = 'X';
    public static final String mensaje_tablero_negativo = "No se puede crear tableros negativos";

    //    private Turn turno;
    int base;
    int height;
    GameState gameState;

    ArrayList<ArrayList<Character>> board = new ArrayList<>();

    public Linea(int promptBase, int promptHeight, char c) {
        if (promptBase < 0 || promptHeight < 0) {
            throw new IllegalArgumentException(mensaje_tablero_negativo);
        }
        this.base = promptBase;
        this.height = promptHeight;
        this.gameState = new RedTurn();


        for (int i = 0; i < this.base; i++) {
            this.board.add(new ArrayList<>());
        }
    }


    public void playRedkAt(int prompt) {
        prompt = prompt - 1;
        checkSpaceAvailability(prompt);
        gameState.checkRedCanPlay();
        board.get(prompt).add(redPiece);
        gameState = new BlueTurn();
        checkWin(redPiece);
    }

    public void playBlueAt(int prompt) {
        prompt = prompt - 1;
        checkSpaceAvailability(prompt);
        gameState.checkBlueCanPlay();
        board.get(prompt).add(bluePiece);
        gameState = new RedTurn();
    }

    private void checkSpaceAvailability(int prompt) {
        if (prompt < 0 || prompt >= base || board.get(prompt).size() >= height) {
            throw new IllegalArgumentException("No se puede jugar en esa posicion");
        }
    }



    public char getPiece(int x, int y) {
        if (isOccupied(x, y)) {
            return board.get(x).get(y);
        } else {
            return emptyPiece;
        }
    }

    private boolean isOccupied(int x, int y) {
        return x < base && y < height && y < board.get(x).size();
    }


    private boolean checkWin(char pieceType) {
        return checkHorizontalWin(pieceType) || checkVerticalWin(pieceType);
    }

    public boolean checkVerticalWin(char pieceType) {
        return IntStream.range(0, base)
                .anyMatch(i -> IntStream.range(0, height - 3)
                                .anyMatch(j -> IntStream.range(0, 4)
                                                .allMatch(k -> getPiece(i, j + k) == pieceType)
                                )
                );
    }

    public boolean checkHorizontalWin(char pieceType) {
        return IntStream.range(0, base - 3)
                .anyMatch(i -> IntStream.range(0, height)
                                .anyMatch(j -> IntStream.range(0, 4)
                                                .allMatch(k -> getPiece(i + k, j) == pieceType)
                                )
                );
    }

//    private boolean checkDiagonalWin(char pieceType) {
//    }


    public boolean isFinished() {
        return checkWin(redPiece) || checkWin(bluePiece);
    }


    public String show() {
        return  "show()";
    }

    public boolean finished() {
        return false;
    }
}


//no se puede crear tableros negativos