package submarine.orientation;

import submarine.XYPositionManager;

public class EastOrientationManager extends OrientationManager {
    public EastOrientationManager() {
        orientationName = "east";
    }
    public XYPositionManager moveForwardAsOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.increaseY();
    }
    public OrientationManager turnRightAsOrientation(OrientationManager orientationManager) {
        return new SouthOrientationManager();
    }
    public OrientationManager turnLeftAsOrientation(OrientationManager orientationManager) {
        return new NorthOrientationManager();
    }
}