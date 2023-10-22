package submarine.orientation;

import submarine.XYPositionManager;

public class NorthOrientationManager extends OrientationManager {
    public NorthOrientationManager() {
        orientationName = "north";
    }
    public XYPositionManager moveForwardAsCurrentOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.increaseX();
    }
    public OrientationManager turnRightAsCurrentOrientation(OrientationManager orientationManager) {
        return new EastOrientationManager();
    }
    public OrientationManager turnLeftAsCurrentOrientation(OrientationManager orientationManager) {
        return new WestOrientationManager();
    }
}
