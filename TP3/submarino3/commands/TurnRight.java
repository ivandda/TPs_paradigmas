package submarino3.commands;
import submarino3.Nemo;

public class TurnRight extends Command {
    public TurnRight() {
        this.charIdentifier = 'r';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.orientationManager = nemo.orientationManager.turnRight(nemo.orientationManager);
    }
}
