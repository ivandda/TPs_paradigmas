package submarino3.commands;

import submarino3.Nemo;

public class TurnLeft extends Command {
    public TurnLeft() {
        this.charIdentifier = 'l';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.orientationManager = nemo.orientationManager.turnLeft(nemo.orientationManager);
    }
}
