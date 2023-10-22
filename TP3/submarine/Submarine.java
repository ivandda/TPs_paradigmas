package submarine;

import submarine.commands.Command;
import submarine.depth.DepthManager;
import submarine.depth.SurfaceManager;
import submarine.orientation.NorthOrientationManager;
import submarine.orientation.OrientationManager;

import java.util.ArrayList;

public class Submarine {
    public OrientationManager orientationManager;
    public XYPositionManager xyPositionManager;
    public DepthManager depthManager;

    public Submarine() {
        this.depthManager = new SurfaceManager();
        this.orientationManager = new NorthOrientationManager();
        this.xyPositionManager = new XYPositionManager(0, 0);
    }

    public Submarine(OrientationManager orientationManager, XYPositionManager xyPositionManager) {
        this.orientationManager = orientationManager;
        this.xyPositionManager = xyPositionManager;
        this.depthManager = new SurfaceManager();
    }


    public Submarine executeInstructions(String instructions) {
        InstructionParser instructionParser = new InstructionParser();
        ArrayList<Command> commands = instructionParser.getCommands(instructions);
        commands.forEach(command -> command.execute(this));
        return this;
    }


    public void goUp() {
        depthManager = this.depthManager.goUpAsCurrentDepth();
    }

    public void goDown() {
        depthManager = depthManager.goDownAsCurrentDepth();
    }

    public void goForward() {
        xyPositionManager = this.orientationManager.moveForwardAsCurrentOrientation(this.xyPositionManager);
    }

    public void ReleaseCapsule() {
        depthManager.releaseCapsuleAsCurrentDepth();
    }

    public void turnLeft() {
        orientationManager = this.orientationManager.turnLeftAsCurrentOrientation(this.orientationManager);
    }

    public void turnRight() {
        orientationManager = this.orientationManager.turnRightAsCurrentOrientation(this.orientationManager);
    }

    public String getAllCoordsAndOrientation() {
        return "Orientation: " + orientationManager.getOrientationName() + " X: " + xyPositionManager.getXCoord() + " Y: " +
                xyPositionManager.getYCoord() + " Z: " + depthManager.getZCoord();
    }
}
