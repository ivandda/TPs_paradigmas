package submarine.orientation;

import submarine.XYPositionManager;

public abstract class OrientationManager {
    String orientationName;
    public abstract XYPositionManager moveForwardAsCurrentOrientation(XYPositionManager xyPositionManager);

    public abstract OrientationManager turnRightAsCurrentOrientation(OrientationManager orientationManager);

    public abstract OrientationManager turnLeftAsCurrentOrientation(OrientationManager orientationManager);

    public String getOrientationName() {return this.orientationName;}
}
