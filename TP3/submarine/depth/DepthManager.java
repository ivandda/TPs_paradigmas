package submarine.depth;

import java.util.ArrayList;

public abstract class DepthManager {
    private ArrayList<DepthManager> upperDepths = new java.util.ArrayList<>();
//    previousDepth
    public abstract DepthManager goDownAsCurrentDepth(DepthManager depthManager);
    public abstract DepthManager goUpAsCurrentDepth(DepthManager depthManager);

    public int getZ() {
        return upperDepths.size();
    }

    public DepthManager appendToUpperDepths(DepthManager stateToAppend) {
        upperDepths.add(stateToAppend);
        return this;
    }

    public DepthManager appendToUpperDepths(ArrayList<DepthManager> statesToAppend) {
        upperDepths.addAll(statesToAppend);
        return this;
    }
    public ArrayList<DepthManager> getAllUpperDepth() {
        return upperDepths;
    }

    public abstract void releaseCapsuleAsCurrentDepth();
}
