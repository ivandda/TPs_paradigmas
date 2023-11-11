package linea;

public class HorizontalOrVertical extends GameMode {
    public HorizontalOrVertical() {
        identifier = 'A';
    }

    @Override
    public boolean checkWin(Linea linea, char bluePiece) {
        return linea.checkVerticalWin(bluePiece) || linea.checkHorizontalWin(bluePiece);
    }
}
