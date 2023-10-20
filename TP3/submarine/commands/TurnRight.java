package submarine.commands;
import submarine.Nemo;

public class TurnRight extends Command {
    public TurnRight() {
        this.identifier = 'r';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.orientationManager = nemo.orientationManager.turnRightAsOrientation(nemo.orientationManager);
    }
}
