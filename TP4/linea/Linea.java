package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
    protected static final String message_invalid_dimensions_for_board = "Invalid dimensions for board";
    protected static final String message_cant_play_in_position = "Can't play in that position";
    private static final char redPiece = 'R';
    private static final char bluePiece = 'B';
    private static final char emptyPiece = ' ';
    ArrayList<ArrayList<Character>> board = new ArrayList<>();
    private int base;
    private int height;
    private GameState gameState;
    private GameMode gameMode;

    public Linea(int promptBase, int promptHeight, char c) {
        if (promptBase <= 0 || promptHeight <= 0) {
            throw new IllegalArgumentException(message_invalid_dimensions_for_board);
        }

        this.base = promptBase;
        this.height = promptHeight;
        this.gameState = new RedTurn();
        this.gameMode = GameMode.setGameMode(c);


        IntStream.range(0, this.base).forEach(i -> this.board.add(new ArrayList<>()));
    }

    private static int offsetPromptToStartInOne(int prompt) {
        return prompt - 1;
    }

    public void playRedAt(int prompt) {
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

    public void addPiece(int column, char pieceType) {
        board.get(column).add(pieceType);
    }

    private void checkSpaceAvailability(int prompt) {
        if (prompt < 0 || prompt >= base || board.get(prompt).size() >= height) {
            throw new IllegalArgumentException(message_cant_play_in_position);
        }
    }

    public char getPiece(int column, int row) {
        return IntStream.range(0, base).filter(x -> x == column && isOccupied(x, row)).mapToObj(x -> board.get(x).get(row)).findFirst().orElse(emptyPiece);
    }

    private boolean isOccupied(int x, int y) {
        return x < base && y < height && y < board.get(x).size();
    }

    public boolean checkVerticalWin(char pieceType) {
        return IntStream.range(0, base).anyMatch(i -> IntStream.range(0, height - 3).anyMatch(j -> IntStream.range(0, 4).allMatch(k -> getPiece(i, j + k) == pieceType)));
    }

    public boolean checkHorizontalWin(char pieceType) {
        return IntStream.range(0, base - 3).anyMatch(i -> IntStream.range(0, height).anyMatch(j -> IntStream.range(0, 4).allMatch(k -> getPiece(i + k, j) == pieceType)));
    }

    public boolean checkDiagonalWin(char pieceType) {
        boolean leftToRightDiagonal = IntStream.range(0, base - 3).anyMatch(startX -> IntStream.range(0, height - 3).anyMatch(startY -> IntStream.range(0, 4).allMatch(offset -> getPiece(startX + offset, startY + offset) == pieceType)));

        boolean rightToLeftDiagonal = IntStream.range(0, base - 3).anyMatch(startX -> IntStream.range(0, height - 3).anyMatch(startY -> IntStream.range(0, 4).allMatch(offset -> startX + offset < base && startY - offset >= 0 && getPiece(startX + offset, startY - offset) == pieceType)));
        return leftToRightDiagonal || rightToLeftDiagonal;
    }

    public boolean finished() {
        return false;
    }

    public String show() {
        return LineaBoardRenderer.render(this);
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }


}


//no se puede crear tableros negativos
// Co-authored-by: demdeo <demdeo@gmail.com>
// Co-authored-by: ivandda <ivandominguezdealzaga@gmail.com>