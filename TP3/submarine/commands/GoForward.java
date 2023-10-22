package submarine.commands;

import submarine.Submarine;

public class GoForward extends Command {
    public GoForward() {this.identifier = 'f';}

    @Override
    public void execute(Submarine submarine) {
        submarine.goForward();}
}