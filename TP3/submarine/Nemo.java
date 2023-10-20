package submarine;

import submarine.depth.DepthManager;
import submarine.depth.Surface;
import submarine.orientation.NorthOrientationManager;
import submarine.orientation.OrientationManager;

public class Nemo {
    public InstructionsManager instructionsManager = new InstructionsManager();
    public OrientationManager orientationManager = new NorthOrientationManager();
    public XYPositionManager xyPositionManager;
    public DepthManager depthManager;

    public Nemo() {
        this.xyPositionManager = new XYPositionManager();
        this.depthManager = new Surface();
    }

    public Nemo(int x, int y , String orientation) {
        this.orientationManager = orientationManager.getOrientationManagerByName(orientation);
        this.xyPositionManager = new XYPositionManager(x,y);
        this.depthManager = new Surface();
    }
}

//pasarle Clases a nemo
