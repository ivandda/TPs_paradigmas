package submarino3.orientation;

import submarino3.XYPositionManager;

public class SouthOrientationManager extends OrientationManager {
    public SouthOrientationManager() {
        orientationName = "south";
    }

    public XYPositionManager moveForwardAsOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.decreaseX();
    }
    public OrientationManager turnRightAsOrientation(OrientationManager orientationManager) {
        return new WestOrientationManager();
    }
    public OrientationManager turnLeftAsOrientation(OrientationManager orientationManager) {
        return new EastOrientationManager();
    }
}
