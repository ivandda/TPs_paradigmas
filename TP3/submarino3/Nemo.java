package submarino3;

import submarino3.orientation.NorthOrientationManager;
import submarino3.orientation.OrientationManager;

public class Nemo {
    public OrientationManager orientationManager;
    public XYPositionManager xyPositionManager;
    public DepthManager depthManager;
    public InstructionsManager instructionsManager;

    public Nemo() {
        this.orientationManager = new NorthOrientationManager();
        this.xyPositionManager = new XYPositionManager();
        this.depthManager = new DepthManager();
        this.instructionsManager = new InstructionsManager();
    }

//    public Nemo(int x, int y , String orientation) {
//        this.orientationManager = new NorthOrientationManager();
//        this.xyPositionManager = new XYPositionManager();
//        this.depthManager = new DepthManager();
//        this.instructionsManager = new InstructionsManager();
//    }

}
