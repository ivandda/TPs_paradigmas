package submarine.depth;

public class FirstUnderwaterManager extends DepthManager{
    @Override
    public DepthManager goDownAsCurrentDepth() {
        return getNextDownLevel(new DeeperUnderwaterManager());
    }

    @Override
    public DepthManager goUpAsCurrentDepth() {
        return new SurfaceManager();
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {}
}
