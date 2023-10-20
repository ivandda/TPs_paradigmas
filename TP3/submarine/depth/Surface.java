package submarine.depth;

public class Surface extends DepthManager{
    @Override
    public DepthManager goDownAsCurrentDepth(DepthManager depthManager) {
        DepthManager nextDepth = new FirstLevelSubmerged();
        return nextDepth.appendToUpperDepths(this);
    }

    @Override
    public DepthManager goUpAsCurrentDepth(DepthManager depthManager) {
        throw new RuntimeException("Cannot go up from surface");
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {
    }
}
