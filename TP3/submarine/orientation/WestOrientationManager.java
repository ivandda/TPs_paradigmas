package submarine.orientation;

import submarine.XYPositionManager;

public class WestOrientationManager extends OrientationManager {
    public WestOrientationManager() {
        orientationName = "west";
    }
    public XYPositionManager moveForwardAsCurrentOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.decreaseY();
    }
    public OrientationManager turnRightAsCurrentOrientation(OrientationManager orientationManager) {
        return new NorthOrientationManager();
    }
    public OrientationManager turnLeftAsCurrentOrientation(OrientationManager orientationManager) {
        return new SouthOrientationManager();
    }
}
