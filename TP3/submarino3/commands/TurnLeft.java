package submarino3.commands;

import submarino3.Nemo;

public class TurnLeft extends Command {
    public TurnLeft() {
        this.identifier = 'l';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.orientationManager = nemo.orientationManager.turnLeftAsOrientation(nemo.orientationManager);
    }
}
