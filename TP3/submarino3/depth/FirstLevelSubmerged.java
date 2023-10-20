package submarino3.depth;

public class FirstLevelSubmerged extends DepthManager{
    @Override
    public DepthManager goDownAsCurrentDepth(DepthManager depthManager) {
        DepthManager nextDepth = new MoreThanFirstLevelSubmerged();
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
