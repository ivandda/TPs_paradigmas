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

    public String show() {
        return "Base: " + this.base + "\nAltura: " + this.height + "\n" + this.board.toString();
    }


    public void playRedkAt(int prompt) {
//        board.get(prompt).add(redPiece);
//        currentTurn.playAsRedAt(prompt);
        gameState.playAsRedAt(prompt, board);
//        gameState = new BlueTurn();
    }


    public void playBlueAt(int prompt) {
//        board.get(prompt).add(bluePiece);
        gameState.playAsBlueAt(prompt, board);
//        gameState = new RedTurn();
    }

//    public char getPiece(int x, int y) {
//        try {
//            return board.get(x).get(y);
//        } catch (Exception e) {
//            return emptyPiece;
//        }
//    }

    public char getPiece(int x, int y) {
        if (isOccupied(x, y)) {
            return board.get(x).get(y);
        } else {
            return emptyPiece;
        }
    }

    public boolean isCurrentPlayerPiece(int x, int y) {
        return getPiece(x, y) == gameState.getPiece();
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
                                        .allMatch(k -> isCurrentPlayerPiece(i, j + k))
//                                .allMatch(k -> getPiece(i, j + k) == pieceType)
                        )
                );
    }

    public boolean checkHorizontalWin(char pieceType) {
        return IntStream.range(0, base - 3)
                .anyMatch(i -> IntStream.range(0, height)
                        .anyMatch(j -> IntStream.range(0, 4)
                                .allMatch(k -> isCurrentPlayerPiece(i, j + k))
//                                .allMatch(k -> getPiece(i + k, j) == pieceType)
                        )
                );
    }

//    private boolean checkDiagonalWin(char pieceType) {
//    }


    public boolean finished() {
        return checkWin(redPiece) || checkWin(bluePiece);
    }
}


//no se puede crear tableros negativos