package submarine.depth;

public class DeeperUnderwaterManager extends DepthManager {

    public static final String release_capsule_error = "Cannot release capsule from more than first level submerged";

    @Override
    public DepthManager goDownAsCurrentDepth() {
        return getNextDownLevel(new DeeperUnderwaterManager());
    }

    @Override
    public DepthManager goUpAsCurrentDepth() {
        return this.getPreviousDepth();
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {
        throw new RuntimeException(release_capsule_error);
    }

}
