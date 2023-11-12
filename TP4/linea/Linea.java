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

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

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
        System.out.println(gameMode.checkWin(this, redPiece));
    }



    public void playBlueAt(int prompt) {
        prompt = offsetPromptToStartInOne(prompt);
        checkSpaceAvailability(prompt);
        gameState.checkBlueCanPlay();
        addPiece(prompt, bluePiece);
        gameState = new RedTurn();
        System.out.println(gameMode.checkWin(this, bluePiece));
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
        return IntStream.range(0, base)
                .filter(x -> x == column && isOccupied(x, row))
                .mapToObj(x -> board.get(x).get(row))
                .findFirst()
                .orElse(emptyPiece);
    }

    private boolean isOccupied(int x, int y) {
        return x < base && y < height && y < board.get(x).size();
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
                                .allMatch(offset -> startX + offset < base && startY - offset >= 0 &&
                                        getPiece(startX + offset, startY - offset) == pieceType)
                        )
                );
        return leftToRightDiagonal || rightToLeftDiagonal;
    }




    public boolean finished() {
        return false;
    }


    public String show() {
        return LineaBoardRenderer.render(this);
    }



}


//no se puede crear tableros negativos
// Co-authored-by: demdeo <demdeo@gmail.com>
// Co-authored-by: ivandda <ivandominguezdealzaga@gmail.com>