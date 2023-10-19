package submarino3.orientation;

import submarino3.XYPositionManager;

public class EastOrienationManager extends OrientationManager {
    @Override
    public String getOrientationName() {
        return "East";
    }
    public XYPositionManager moveForward(XYPositionManager xyPositionManager) {
        return xyPositionManager.increaseY();
    }
    public OrientationManager turnRight(OrientationManager orientationManager) {
        return new SouthOrientationManager();
    }
    public OrientationManager turnLeft(OrientationManager orientationManager) {
        return new NorthOrientationManager();
    }
}
