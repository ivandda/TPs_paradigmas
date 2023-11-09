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


    public boolean finished() {
        return false;
    }

    public String show() {
        //this was made by demdeo
        String baseStr = String.valueOf(base);
        String heightStr = String.valueOf(height);

        StringBuilder boardString = new StringBuilder();

        // Box-drawing characters for the corners and horizontal/vertical dividers
        // Deberian ser constantes
        char horizontalLine = '─';
        char verticalLine = '│';
        char cross = '┼';

        StringBuilder rowHeaderBuilder = new StringBuilder();
        rowHeaderBuilder.append(" ".repeat(heightStr.length() + 1));
        rowHeaderBuilder.append(cross);

        IntStream.range(0, base).forEach(i -> {
            rowHeaderBuilder.append(horizontalLine).append(horizontalLine).append(horizontalLine);
            rowHeaderBuilder.append(cross);
        });
        rowHeaderBuilder.append("\n");
        boardString.append(rowHeaderBuilder.toString());

        // Add board representation and row index numbers
        StringBuilder rowBuilder = new StringBuilder();
        IntStream.range(0, height).forEach(i -> {
            int rowNumber = i + 1;
            rowBuilder.append(rowNumber).append(" ".repeat(heightStr.length() - String.valueOf(rowNumber).length() + 1)).append(verticalLine);
            IntStream.range(0, base).forEach(j -> {
                rowBuilder.append(" ").append(getPiece(j, height - 1 - i)).append(" ");
                rowBuilder.append(verticalLine);
            });
            rowBuilder.append("\n");

            rowBuilder.append(" ").append(" ".repeat(heightStr.length())).append(cross);
            IntStream.range(0, base).forEach(j -> {
                rowBuilder.append(horizontalLine).append(horizontalLine).append(horizontalLine);
                rowBuilder.append(cross);
            });

            rowBuilder.append("\n");
        });
        boardString.append(rowBuilder.toString());

        // Add column index numbers
        StringBuilder rowFooterBuilder = new StringBuilder();

        rowFooterBuilder.append(" ".repeat(heightStr.length()));
        IntStream.range(0, base).forEach(i -> {
            rowFooterBuilder.append(" ".repeat(4 - String.valueOf(i + 1).length()));
            rowFooterBuilder.append(i + 1);
        });
        rowFooterBuilder.append("\n");
        boardString.append(rowFooterBuilder.toString());
        return boardString.toString();
    }
}


//no se puede crear tableros negativos