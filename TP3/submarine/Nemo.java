package submarine;

import submarine.depth.DepthManager;
import submarine.depth.Surface;
import submarine.orientation.NorthOrientationManager;
import submarine.orientation.OrientationManager;

public class Nemo {
    public OrientationManager orientationManager;
    public XYPositionManager xyPositionManager;
    public DepthManager depthManager;
    public InstructionsManager instructionsManager = new InstructionsManager();

    public Nemo() {
        this.orientationManager = new NorthOrientationManager();
        this.xyPositionManager = new XYPositionManager();
        this.depthManager = new Surface();
    }

    public Nemo(int x, int y , String orientation) {
        OrientationManager a = new NorthOrientationManager();
        this.orientationManager = a.getOrientationManagerByName(orientation);
        this.xyPositionManager = new XYPositionManager();
        this.depthManager = new Surface();
    }
}
