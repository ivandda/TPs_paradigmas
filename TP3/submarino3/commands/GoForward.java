package submarino3.commands;

import submarino3.Nemo;

public class GoForward extends Command {
    public GoForward() {
        this.charIdentifier = 'f';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.xyPositionManager = nemo.orientationManager.moveForward(nemo.xyPositionManager);
    }
}
