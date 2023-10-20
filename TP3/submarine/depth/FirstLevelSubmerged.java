package submarine.depth;

public class FirstLevelSubmerged extends DepthManager{
    @Override
    public DepthManager goDownAsCurrentDepth(DepthManager depthManager) {
        DepthManager nextDepth = new DeepLevel();
        return nextDepth.appendToUpperDepths(this.getAllUpperDepth()).appendToUpperDepths(this);
    }

    @Override
    public DepthManager goUpAsCurrentDepth(DepthManager depthManager) {
        return new Surface();
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {
    }
}
