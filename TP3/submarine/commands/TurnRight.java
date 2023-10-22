package submarine.commands;
import submarine.Submarine;

public class TurnRight extends Command {
    public TurnRight() {this.identifier = 'r';}

    @Override
    public void execute(Submarine submarine) {
        submarine.turnRight();}
}
