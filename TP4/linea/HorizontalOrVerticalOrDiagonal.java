package linea;

public class HorizontalOrVerticalOrDiagonal extends GameMode {
    public HorizontalOrVerticalOrDiagonal() {
        identifier = 'C';
    }

    @Override
    public boolean checkWin(Linea linea, char bluePiece) {
        return linea.checkVerticalWin(bluePiece) || linea.checkHorizontalWin(bluePiece) || linea.checkDiagonalWin(bluePiece);
    }
}
