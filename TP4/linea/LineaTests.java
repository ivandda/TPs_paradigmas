package linea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LineaTests {
    private Linea lineaA7x6;
    private Linea lineBA7x6;
    private Linea lineaC7x6;

    @BeforeEach
    public void setUp() {
        lineaA7x6 = new Linea(7, 6, 'A');
        lineBA7x6 = new Linea(7, 6, 'B');
        lineaC7x6 = new Linea(7, 6, 'C');
    }

    @Test
    public void addingARedPieceAddsItCorrectly() {
        lineaA7x6.playRedAt(1);
        assertEquals('R', lineaA7x6.getPiece(1, 0));
        lineaA7x6.playRedAt(1);
        assertEquals('R', lineaA7x6.getPiece(1, 1));
    }

    @Test
    public void redPlayerStartsGame() {
        lineaA7x6.playRedAt(1);
        assertEquals('R', lineaA7x6.getPiece(1, 0));
    }

    @Test
    public void BluePlayerPlaysAfterRedPlayer() {
        lineaA7x6.playRedAt(1);
        lineaA7x6.playBlueAt(1);
        assertEquals('B', lineaA7x6.getPiece(1, 1));
    }
}
