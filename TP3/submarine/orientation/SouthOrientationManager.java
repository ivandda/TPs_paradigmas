package submarine.orientation;

import submarine.XYPositionManager;

public class SouthOrientationManager extends OrientationManager {
    public SouthOrientationManager() {
        orientationName = "south";
    }

    public XYPositionManager moveForwardAsCurrentOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.decreaseX();
    }
    public OrientationManager turnRightAsCurrentOrientation(OrientationManager orientationManager) {
        return new WestOrientationManager();
    }
    public OrientationManager turnLeftAsCurrentOrientation(OrientationManager orientationManager) {
        return new EastOrientationManager();
    }
}
