package linea;

public class Diagonals extends GameMode {
    public Diagonals() {
        identifier = 'B';
    }

    @Override
    public boolean checkWin(Linea linea, char pieceType) {
        return linea.checkDiagonalWin(pieceType);
    }
}
