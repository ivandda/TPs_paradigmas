package linea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;

import static linea.GameMode.invalid_game_mode_choice;
import static linea.Linea.message_cant_play_in_position;
import static linea.Linea.message_invalid_dimensions_for_board;
import static org.junit.jupiter.api.Assertions.*;


public class LineaTests {
    private Linea game;
    private Linea gameB;

    @BeforeEach
    public void setUp() {
        game = new Linea(4, 4, 'A');
    }

    @Test
    public void test01CannotInitializeBoardSmallerThan1x1() {
        assertThrowsError(() -> new Linea(0, 0, 'A'), message_invalid_dimensions_for_board);
    }

    @Test
    public void test02CannotInitializeBoardWithNegativeDimensions() {
        assertThrowsError(() -> new Linea(-4, -4, 'A'), message_invalid_dimensions_for_board);
    }

    @Test
    public void test03CannotInitializeGameWithInvalidGameMode() {
        assertThrowsError(() -> new Linea(4, 4, 'D'), invalid_game_mode_choice);
    }

    @Test
    public void test04GameIsInitializedCorrectly() {
        IntStream.range(0, 4).forEach(column -> {
            IntStream.range(0, 4).forEach(row -> {
                assertEquals(' ', game.getPiece(column, row));
            });
        });
    }

    @Test
    public void test04RedStartsGame() {
        assertEquals("Red's turn", game.getCurrentState());
    }

    @Test
    public void test05CannotPlayOutsideBoard() {
        assertThrowsError(() -> game.playRedAt(5), message_cant_play_in_position);
    }

    @Test
    public void test06CannotPlayInColumn0() {
        assertThrowsError(() -> game.playRedAt(0), message_cant_play_in_position);
    }

    @Test
    public void test07PrintsEmptyBoard() {
        String boardRenderExpected = """
                Red's turn
                            
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test08PrintsRedPieces() {
        game.playRedAt(2);
        String boardRenderExpected = """
                Blue's turn
                        
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║   ║ R ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test09PrintsBluePieces() {
        game.playRedAt(2);
        game.playBlueAt(2);
        String boardRenderExpected = """
                Red's turn
                        
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║   ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║   ║ R ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test10PrintsRedAndBluePieces() {
        playLinea(2, 2, 3, 3);
        String boardRenderExpected = """
                Red's turn
                        
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║   ║ B ║ B ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║   ║ R ║ R ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test11AlternateTurnsAndPlacePieces() {
        playLinea(2, 2, 3, 3, 2, 2, 3, 3);
        String boardRenderExpected = """
                Red's turn
                        
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║ B ║ B ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║ R ║ R ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║   ║ B ║ B ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║   ║ R ║ R ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

// Test that a piece cannot be placed in a full column.

    @Test
    public void test12CannotPlayInFullColumn() {
        playLinea(2, 2, 2, 2);
        assertThrowsError(() -> game.playRedAt(2), message_cant_play_in_position);
    }

// Test that pieces are positioned at the lowest available position.

    @Test
    public void test13PiecesArePositionedAtTheLowestAvailablePosition() {
        playLinea(1, 2, 3, 4, 4, 3, 2, 1);
        String boardRenderExpected = """
                Red's turn
                        
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ B ║ R ║ B ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ B ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test14RedHasHorizontalLine() {
        playLinea(1, 1, 2, 2, 3, 3, 4);
        String boardRenderExpected = """
                Game ended: Red won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ B ║ B ║ B ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ R ║ R ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test15BlueHasHorizontalLine() {
        playLinea(1, 1, 2, 2, 3, 3, 1, 4, 2, 4);
        String boardRenderExpected = """
                Game ended: Blue won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║ R ║ R ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ B ║ B ║ B ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ R ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test16RedHasVerticalLine() {
        playLinea(1, 2, 1, 2, 1, 2, 1);
        String boardRenderExpected = """
                Game ended: Red won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║ R ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║ R ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ R ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test17BlueHasVerticalLine() {
        playLinea(1, 2, 1, 2, 1, 2, 3, 2);
        String boardRenderExpected = """
                Game ended: Blue won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║ R ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ R ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ B ║ R ║   ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test18RedHasDiagonalLine() {
        game = newLineaB();
        playLinea(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4);
        String boardRenderExpected = """
                Game ended: Red won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║ R ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ B ║ R ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ B ║ B ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    // Test that blue has a diagonal line.
    @Test
    public void test19BlueHasDiagonalLine() {
        game = newLineaB();
        playLinea(2, 1, 3, 2, 3, 3, 4, 4, 4, 4);
        String boardRenderExpected = """
                Game ended: Blue won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║   ║   ║   ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║   ║   ║ B ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║   ║ B ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ B ║ R ║ R ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

    @Test
    public void test20BlueHasDiagonalLineInverted() {
        game = newLineaB();
        playLinea(1, 2, 3, 4, 1, 3, 2, 2, 1, 1);
        String boardRenderExpected = """
                Game ended: Blue won
                    
                  ╬═══╬═══╬═══╬═══╬
                4 ║ B ║   ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║ R ║ B ║   ║   ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ R ║ R ║ B ║   ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ B ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

// Test that the game ends in a draw.

    @Test
    public void test21GameEndsInADraw() {
        game = newLineaC();
        playLinea(1, 2, 1, 2, 2, 1, 2, 1, 3, 4, 3, 4, 4, 3, 4, 3);
        String boardRenderExpected = """
                Game ended: Draw
                        
                  ╬═══╬═══╬═══╬═══╬
                4 ║ B ║ R ║ B ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                3 ║ B ║ R ║ B ║ R ║
                  ╬═══╬═══╬═══╬═══╬
                2 ║ R ║ B ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                1 ║ R ║ B ║ R ║ B ║
                  ╬═══╬═══╬═══╬═══╬
                    1   2   3   4
                """;
        assertEquals(boardRenderExpected, game.show());
    }

// Test that the game ends when red wins.

    @Test
    public void test22GameEndsWhenRedWins() {
        game = newLineaB();
        playLinea(1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4);
        assertThrowsError(() -> game.playBlueAt(3), "Blue cant play in this round");
    }

// Test that the game ends when blue wins.

    @Test
    public void test23GameEndsWhenBlueWins() {
        game = newLineaB();
        playLinea(2, 1, 3, 2, 3, 3, 4, 4, 4, 4);
        assertThrowsError(() -> game.playRedAt(3), "Red cant play in this round");
    }

// Test that a piece cannot be placed when the game ends in a draw.

    private Linea playLinea(int... moves) {
        for (int i = 0; i < moves.length; i += 2) {
            game.playRedAt(moves[i]);
            if (i + 1 == moves.length) break;
            game.playBlueAt(moves[i + 1]);
        }
        return game;
    }

    private void assertThrowsError(Executable runnable, String expectedError) {
        String actualError = assertThrows(RuntimeException.class, runnable, "Expected Error was not thrown.").getMessage();
        assertEquals(expectedError, actualError);
    }

    private Linea newLineaB() {
        return new Linea(4, 4, 'B');
    }

    private Linea newLineaC() {
        return new Linea(4, 4, 'C');
    }
}