package submarino3.orientation;

import submarino3.XYPositionManager;

public class SouthOrientationManager extends OrientationManager {
    @Override
    public String getOrientationName() {
        return "South";
    }

    public XYPositionManager moveForward(XYPositionManager xyPositionManager) {
        return xyPositionManager.decreaseX();
    }
    public OrientationManager turnRight(OrientationManager orientationManager) {
        return new WestOrientationManager();
    }
    public OrientationManager turnLeft(OrientationManager orientationManager) {
        return new EastOrienationManager();
    }
}
