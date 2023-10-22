package submarine.commands;

import submarine.Submarine;

public class ReleaseCapsule extends Command {
    public ReleaseCapsule() {this.identifier = 'm';}

    @Override
    public void execute(Submarine submarine) {
        submarine.ReleaseCapsule();}
}
