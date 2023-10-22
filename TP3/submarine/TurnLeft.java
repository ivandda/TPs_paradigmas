package submarine;

public class TurnLeft extends Command {
    public TurnLeft() {super('l');}

    @Override
    public void execute(Submarine submarine) {
        submarine.turnLeft();}
}
