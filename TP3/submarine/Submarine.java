package submarine;

import submarine.depth.DepthManager;
import submarine.depth.Surface;
import submarine.orientation.NorthOrientationManager;
import submarine.orientation.OrientationManager;

public class Submarine {
    public InstructionsManager instructionsManager = new InstructionsManager();
    public OrientationManager orientationManager;
    public XYPositionManager xyPositionManager;
    public DepthManager depthManager;

    public Submarine() {
        this.depthManager = new Surface();
        this.orientationManager = new NorthOrientationManager();
        this.xyPositionManager = new XYPositionManager(0, 0);
    }

    public Submarine(OrientationManager orientationManager, XYPositionManager xyPositionManager) {
        this.orientationManager = orientationManager;
        this.xyPositionManager = xyPositionManager;
        this.depthManager = new Surface();
    }


//    public void executeInstructions(String instructions) {
//        this.instructionsManager.executeInstructions(instructions, this);
//    }

        public Submarine executeInstructions(String instructions) {
        this.instructionsManager.executeInstructions(instructions, this);
        return this;
    }


    public void goUp() {
        depthManager = this.depthManager.goUpAsCurrentDepth();
    }

    public void goDown() {
        depthManager = depthManager.goDownAsCurrentDepth();
    }

    public void goForward() {
        xyPositionManager = this.orientationManager.moveForwardAsOrientation(this.xyPositionManager);
    }

    public void ReleaseCapsule() {
        depthManager.releaseCapsuleAsCurrentDepth();
    }

    public void turnLeft() {
        orientationManager = this.orientationManager.turnLeftAsOrientation(this.orientationManager);
    }

    public void turnRight() {
        orientationManager = this.orientationManager.turnRightAsOrientation(this.orientationManager);
    }

    public String getAllCoordsAndOrientation() {
        return "Orientation: " + orientationManager.getOrientationName() + " X: " + xyPositionManager.getXCoord() + " Y: " +
                xyPositionManager.getYCoord() + " Z: " + depthManager.getZCoord();
    }
}
