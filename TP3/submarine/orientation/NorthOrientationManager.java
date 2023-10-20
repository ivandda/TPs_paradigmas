package submarine.orientation;

import submarine.XYPositionManager;

public class NorthOrientationManager extends OrientationManager {
    public NorthOrientationManager() {
        orientationName = "north";
    }
    public XYPositionManager moveForwardAsOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.increaseX();
    }
    public OrientationManager turnRightAsOrientation(OrientationManager orientationManager) {
        return new EastOrientationManager();
    }
    public OrientationManager turnLeftAsOrientation(OrientationManager orientationManager) {
        return new WestOrientationManager();
    }
}