package submarino3.orientation;

import submarino3.XYPositionManager;

public class WestOrientationManager extends OrientationManager {
    WestOrientationManager() {
        orientationName = "west";
    }
    public XYPositionManager moveForwardAsOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.decreaseY();
    }
    public OrientationManager turnRightAsOrientation(OrientationManager orientationManager) {
        return new NorthOrientationManager();
    }
    public OrientationManager turnLeftAsOrientation(OrientationManager orientationManager) {
        return new SouthOrientationManager();
    }
}
