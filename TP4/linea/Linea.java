package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
    //    add Getters
    public static final char HORIZONTAL_LINE = '─';
    public static final char VERTICAL_LINE = '│';
    public static final char CROSS = '┼';
    public static final char redPiece = 'R';
    public static final char bluePiece = 'B';
    public static final char emptyPiece = ' ';
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
//        gameMode.checkWin(this, redPiece);
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


    public char getPiece(int column, int row) {
        return board.get(column).stream()
                .filter(piece -> isOccupied(column, row))
                .findFirst()
                .orElse(emptyPiece);
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
        StringBuilder boardString = new StringBuilder();

        boardString.append(generateRowHeader());
        boardString.append(generateBoardRepresentation());
        boardString.append(generateColumnNumbers());

        return boardString.toString();
    }

    private String generateRowHeader() {
        String heightStr = String.valueOf(height);
        StringBuilder rowHeaderBuilder = new StringBuilder();

        rowHeaderBuilder.append(" ".repeat(heightStr.length() + 1));
        rowHeaderBuilder.append(CROSS);

        IntStream.range(0, base).forEach(column -> {
            rowHeaderBuilder.append(HORIZONTAL_LINE).append(HORIZONTAL_LINE).append(HORIZONTAL_LINE);
            rowHeaderBuilder.append(CROSS);
        });
        rowHeaderBuilder.append("\n");

        return rowHeaderBuilder.toString();
    }

    private String generateBoardRepresentation() {
        StringBuilder rowBuilder = new StringBuilder();
        String heightStr = String.valueOf(height);

        IntStream.range(0, height).forEach(row -> {
            int rowNumber = height - row;
            rowBuilder.append(rowNumber).append(" ".repeat(heightStr.length() - String.valueOf(rowNumber).length() + 1)).append(VERTICAL_LINE);
            IntStream.range(0, base).forEach(column -> {
                rowBuilder.append(" ").append(getPiece(column, rowNumber - 1)).append(" ");
                rowBuilder.append(VERTICAL_LINE);
            });
            rowBuilder.append("\n");

            rowBuilder.append(" ").append(" ".repeat(heightStr.length())).append(CROSS);
            IntStream.range(0, base).forEach(column -> {
                rowBuilder.append(HORIZONTAL_LINE).append(HORIZONTAL_LINE).append(HORIZONTAL_LINE);
                rowBuilder.append(CROSS);
            });

            rowBuilder.append("\n");
        });
        return rowBuilder.toString();
    }

    private String generateColumnNumbers() {
        StringBuilder rowFooterBuilder = new StringBuilder();
        String heightStr = String.valueOf(height);

        rowFooterBuilder.append(" ".repeat(heightStr.length()));
        IntStream.range(0, base).forEach(column -> {
            rowFooterBuilder.append(" ".repeat(4 - String.valueOf(column + 1).length()));
            rowFooterBuilder.append(column + 1);
        });
        rowFooterBuilder.append("\n");

        return rowFooterBuilder.toString();
    }
}


//no se puede crear tableros negativos
// Co-authored-by: demdeo <demdeo@gmail.com>
// Co-authored-by: ivandda <ivandominguezdealzaga@gmail.com>