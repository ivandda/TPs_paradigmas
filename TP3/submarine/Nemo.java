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

    public void executeInstructions(String instructions) {
        this.instructionsManager.executeInstructions(instructions, this);
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

}

//pasarle Clases a nemo
