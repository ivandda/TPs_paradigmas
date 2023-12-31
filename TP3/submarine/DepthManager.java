package submarine;

public abstract class DepthManager {
    private DepthManager previousDepth;
    private int zCoord;

    public abstract DepthManager goDownAsCurrentDepth();

    public abstract DepthManager goUpAsCurrentDepth();

    public abstract void releaseCapsuleAsCurrentDepth();

    public DepthManager getNextDownLevel(DepthManager nexDwnLevelDepthManager) {
        return nexDwnLevelDepthManager.setZCoord(this.getZCoord() + 1).setPreviousDepth(this);
    }

    public DepthManager getPreviousDepth() {return previousDepth;}
    public int getZCoord() {return zCoord;}

    public DepthManager setPreviousDepth(DepthManager previousDepth) {
        this.previousDepth = previousDepth;
        return this;
    }

    private DepthManager setZCoord(int zCoord) {
        this.zCoord = zCoord;
        return this;
    }
}
