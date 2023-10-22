package submarine.commands;

import submarine.Submarine;

public class GoUp extends Command {
    public GoUp() {this.identifier = 'u';}

    @Override
    public void execute(Submarine submarine) {
        submarine.goUp();}
}
