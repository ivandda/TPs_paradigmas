package submarine.orientation;

import submarine.XYPositionManager;
import java.util.Objects;

public abstract class OrientationManager {
    String orientationName;
    public abstract XYPositionManager moveForwardAsOrientation(XYPositionManager xyPositionManager);

    public abstract OrientationManager turnRightAsOrientation(OrientationManager orientationManager);

    public abstract OrientationManager turnLeftAsOrientation(OrientationManager orientationManager);

    public String getOrientationName() {return this.orientationName;}
}
