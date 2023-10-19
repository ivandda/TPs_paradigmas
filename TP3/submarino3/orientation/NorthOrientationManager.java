package submarino3.orientation;

import submarino3.XYPositionManager;

public class NorthOrientationManager extends OrientationManager {
    @Override
    public String getOrientationName() {
        return "North";
    }
    public XYPositionManager moveForward(XYPositionManager xyPositionManager) {
        return xyPositionManager.increaseX();
    }
    public OrientationManager turnRight(OrientationManager orientationManager) {
        return new EastOrienationManager();
    }
    public OrientationManager turnLeft(OrientationManager orientationManager) {
        return new WestOrientationManager();
    }
}
