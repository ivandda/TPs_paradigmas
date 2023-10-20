package submarine.commands;

import submarine.Nemo;

public class ReleaseCapsule extends Command {
    public ReleaseCapsule() {
        this.identifier = 'm';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.depthManager.releaseCapsuleAsCurrentDepth();
    }
}
