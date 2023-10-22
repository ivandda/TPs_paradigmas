package submarine;

public class GoUp extends Command {
    public GoUp() {super('u');}

    @Override
    public void execute(Submarine submarine) {
        submarine.goUp();}
}
