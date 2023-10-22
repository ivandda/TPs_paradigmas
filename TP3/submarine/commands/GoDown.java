package submarine.commands;

import submarine.Submarine;

public class GoDown extends Command {
    public GoDown() {this.identifier = 'd';}

    @Override
    public void execute(Submarine submarine) {
        submarine.goDown();}
}

