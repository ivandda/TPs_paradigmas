package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
    //    add Getters
    public static final char redPiece = 'R';
    public static final char bluePiece = 'B';
    public static final char emptyPiece = 'X';
    public static final String mensaje_tablero_invalido = "No se puede crear tableros con esas dimensiones";
    public static final String message_cant_play_in_position = "No se puede jugar en esa posicion";
    ArrayList<ArrayList<Character>> board = new ArrayList<>();
    private int base;
    private int height;
    private GameState gameState;

//    private ArrayList<GameMode> possibleGameModes = new ArrayList<>();
//    possibleGameModes.add(new GMA());
//    possibleGameModes.add(new GMB());
//    possibleGameModes.add(new GMC());
    private GameMode gameMode;

    public Linea(int promptBase, int promptHeight, char c) {
        if (promptBase <= 0 || promptHeight <= 0) {
            throw new IllegalArgumentException(mensaje_tablero_invalido);
        }

        this.base = promptBase;
        this.height = promptHeight;
        this.gameState = new RedTurn();
        this.gameMode = GameMode.setGameMode(c);


        IntStream.range(0, this.base).forEach(i -> this.board.add(new ArrayList<>()));
    }


    public void playRedkAt(int prompt) {
        prompt = offsetPromptToStartInOne(prompt);
        checkSpaceAvailability(prompt);
        gameState.checkRedCanPlay();
        addPiece(prompt, redPiece);
        gameState = new BlueTurn();
        checkWin(redPiece);
    }



    public void playBlueAt(int prompt) {
        prompt = offsetPromptToStartInOne(prompt);
        checkSpaceAvailability(prompt);
        gameState.checkBlueCanPlay();
        addPiece(prompt, bluePiece);
        gameState = new RedTurn();
        checkWin(bluePiece);
    }

    private static int offsetPromptToStartInOne(int prompt) {
        return prompt -1;
    }

    public void addPiece(int column, char pieceType) {
        board.get(column).add(pieceType);
    }

    private void checkSpaceAvailability(int prompt) {
        if (prompt < 0 || prompt >= base || board.get(prompt).size() >= height) {
            throw new IllegalArgumentException(message_cant_play_in_position);
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

    public boolean checkDiagonalWin(char pieceType) {
        boolean leftToRightDiagonal = IntStream.range(0, base - 3)
                .anyMatch(startX -> IntStream.range(0, height - 3)
                        .anyMatch(startY -> IntStream.range(0, 4)
                                .allMatch(offset -> getPiece(startX + offset, startY + offset) == pieceType)
                        )
                );

        boolean rightToLeftDiagonal = IntStream.range(0, base - 3)
                .anyMatch(startX -> IntStream.range(0, height - 3)
                        .anyMatch(startY -> IntStream.range(0, 4)
                                .allMatch(offset -> getPiece(startX + offset, startY - offset) == pieceType)
                        )
                );
        return leftToRightDiagonal || rightToLeftDiagonal;
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
// Co-authored-by: demdeo <demdeo@gmail.com>
// Co-authored-by: ivandda <ivandominguezdealzaga@gmail.com>