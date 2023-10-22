package submarine;

public class GoDown extends Command {
    public GoDown() {super('d');}

    @Override
    public void execute(Submarine submarine) {
        submarine.goDown();}
}

