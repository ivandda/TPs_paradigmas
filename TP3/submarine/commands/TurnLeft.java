package submarine.commands;

import submarine.Nemo;

public class TurnLeft extends Command {
    public TurnLeft() {this.identifier = 'l';}

    @Override
    public void execute(Nemo nemo) {nemo.turnLeft();}
}
