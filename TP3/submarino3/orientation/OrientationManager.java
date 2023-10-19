package submarino3.orientation;

import submarino3.XYPositionManager;

public abstract class OrientationManager {
    public abstract String getOrientationName();
    public abstract XYPositionManager moveForward(XYPositionManager xyPositionManager);
    public abstract OrientationManager turnRight(OrientationManager orientationManager);
    public abstract OrientationManager turnLeft(OrientationManager orientationManager);
}
