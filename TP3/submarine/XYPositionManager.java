package submarine;

public class XYPositionManager {
    private int xCoord;
    private int yCoord;

    public XYPositionManager(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public XYPositionManager increaseX() {
        return new XYPositionManager(this.xCoord + 1, this.yCoord);
    }

    public XYPositionManager decreaseX() {
       return new XYPositionManager(this.xCoord - 1, this.yCoord);
    }

    public XYPositionManager increaseY() {
        return new XYPositionManager(this.xCoord, this.yCoord + 1);
    }

    public XYPositionManager decreaseY() {
        return new XYPositionManager(this.xCoord, this.yCoord - 1);
    }

    public int getXCoord() {return this.xCoord;}

    public int getYCoord() {return this.yCoord;}
}