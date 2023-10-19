package submarino3;

public class XYPositionManager {
    private int x;
    private int y;

    public XYPositionManager() {
        this.x = 0;
        this.y = 0;
    }

    public XYPositionManager(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public XYPositionManager increaseX() {
        return new XYPositionManager(this.x + 1, this.y);
    }

    public XYPositionManager decreaseX() {
       return new XYPositionManager(this.x - 1, this.y);
    }

    public XYPositionManager increaseY() {
        return new XYPositionManager(this.x, this.y + 1);
    }

    public XYPositionManager decreaseY() {
        return new XYPositionManager(this.x, this.y - 1);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}