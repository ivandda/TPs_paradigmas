package submarine;

public class EastOrientationManager extends OrientationManager {
    public EastOrientationManager() {
        orientationName = "east";
    }
    public XYPositionManager moveForwardAsCurrentOrientation(XYPositionManager xyPositionManager) {
        return xyPositionManager.increaseY();
    }
    public OrientationManager turnRightAsCurrentOrientation(OrientationManager orientationManager) {
        return new SouthOrientationManager();
    }
    public OrientationManager turnLeftAsCurrentOrientation(OrientationManager orientationManager) {
        return new NorthOrientationManager();
    }
}
