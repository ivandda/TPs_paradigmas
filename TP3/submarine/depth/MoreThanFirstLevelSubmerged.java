package submarine.depth;

public class MoreThanFirstLevelSubmerged extends DepthManager {
    @Override
    public DepthManager goDownAsCurrentDepth(DepthManager depthManager) {
        DepthManager nextDepth = new MoreThanFirstLevelSubmerged();
        return nextDepth.appendToUpperDepths(this.getAllUpperDepth()).appendToUpperDepths(this);
    }

    @Override
    public DepthManager goUpAsCurrentDepth(DepthManager depthManager) {
        return this.getAllUpperDepth().get(this.getAllUpperDepth().size() - 1);
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {
        throw new RuntimeException("Cannot release capsule from more than first level submerged");
    }

}
