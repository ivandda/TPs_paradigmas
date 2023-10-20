package submarino3.commands;

import submarino3.Nemo;

public class GoDown extends Command {
    public GoDown() {
        this.identifier = 'd';
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.depthManager = nemo.depthManager.goDownAsCurrentDepth(nemo.depthManager);
    }
}

