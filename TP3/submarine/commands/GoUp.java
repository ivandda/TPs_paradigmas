package submarine.commands;

import submarine.Nemo;

public class GoUp extends Command {
    public GoUp() {
        this.identifier = 'u';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.depthManager = nemo.depthManager.goUpAsCurrentDepth(nemo.depthManager);
    }
}
