package submarine.depth;

public class FirstLevelSubmerged extends DepthManager{
    @Override
    public DepthManager goDownAsCurrentDepth() {
        return getNextDownLevel(new DeepLevel());
    }

    @Override
    public DepthManager goUpAsCurrentDepth() {
        return new Surface();
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {
    }
}
