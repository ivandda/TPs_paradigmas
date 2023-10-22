package submarine.depth;

public abstract class DepthManager {
    private DepthManager previousDepth;
    private int xCoord;

    //    previousDepth
    public abstract DepthManager goDownAsCurrentDepth();

    public abstract DepthManager goUpAsCurrentDepth();

    public abstract void releaseCapsuleAsCurrentDepth();

    public DepthManager getNextDownLevel(DepthManager nexDwnLevelDepthManager) {
        return nexDwnLevelDepthManager.setxCoord(this.getxCoord() + 1).setPreviousDepth(this);
    }

    public DepthManager getPreviousDepth() {return previousDepth;}
    public int getxCoord() {return xCoord;}

    public DepthManager setPreviousDepth(DepthManager previousDepth) {
        this.previousDepth = previousDepth;
        return this;
    }

    public DepthManager setxCoord(int xCoord) {
        this.xCoord = xCoord;
        return this;
    }
}
