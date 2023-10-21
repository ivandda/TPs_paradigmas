package submarine.commands;

import submarine.Nemo;

public class GoDown extends Command {
    public GoDown() {this.identifier = 'd';}

    @Override
    public void execute(Nemo nemo) {nemo.goDown();}
}

