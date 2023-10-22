package submarine.commands;

import submarine.Submarine;

public class TurnLeft extends Command {
    public TurnLeft() {this.identifier = 'l';}

    @Override
    public void execute(Submarine submarine) {
        submarine.turnLeft();}
}
