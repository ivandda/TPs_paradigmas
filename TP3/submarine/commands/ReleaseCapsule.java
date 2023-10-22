package submarine.commands;

import submarine.Submarine;

public class ReleaseCapsule extends Command {
    public ReleaseCapsule() {super('m');}

    @Override
    public void execute(Submarine submarine) {
        submarine.ReleaseCapsule();}
}
