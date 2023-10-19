package submarino3.orientation;

import submarino3.XYPositionManager;

public class WestOrientationManager extends OrientationManager {
    public String getOrientationName() {
        return "West";
    }
    public XYPositionManager moveForward(XYPositionManager xyPositionManager) {
        return xyPositionManager.decreaseY();
    }
    public OrientationManager turnRight(OrientationManager orientationManager) {
        return new NorthOrientationManager();
    }
    public OrientationManager turnLeft(OrientationManager orientationManager) {
        return new SouthOrientationManager();
    }
}
