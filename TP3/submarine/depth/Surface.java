package submarine.depth;

public class Surface extends DepthManager{

    public static final String cannot_go_up_from_surface_level_error = "Cannot go up from surface";

    @Override
    public DepthManager goDownAsCurrentDepth() {
        return getNextDownLevel(new FirstLevelSubmerged());
    }

    @Override
    public DepthManager goUpAsCurrentDepth() {
        throw new RuntimeException(cannot_go_up_from_surface_level_error);
    }

    @Override
    public void releaseCapsuleAsCurrentDepth() {
    }
}
