package submarino3;

import submarino3.depth.DepthManager;
import submarino3.depth.Surface;
import submarino3.orientation.NorthOrientationManager;
import submarino3.orientation.OrientationManager;

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
