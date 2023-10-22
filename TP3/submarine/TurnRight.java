package submarine;

public class TurnRight extends Command {
    public TurnRight() {super('r');}

    @Override
    public void execute(Submarine submarine) {
        submarine.turnRight();}
}
